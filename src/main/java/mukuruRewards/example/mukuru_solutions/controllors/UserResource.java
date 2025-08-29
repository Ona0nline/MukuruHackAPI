package mukuruRewards.example.mukuru_solutions.controllors;

import jakarta.servlet.http.HttpSession;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.LoginDTO;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.SignUpDTO;
import mukuruRewards.example.mukuru_solutions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;

    @PostMapping("/signup")
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    public ResponseEntity<?> signup(@RequestBody SignUpDTO signUpDTO){
        session.setAttribute("username", signUpDTO.getUsername());
        session.setAttribute("email", signUpDTO.getEmail());
        return ResponseEntity.ok(userService.signup(signUpDTO));
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://127.0.0.1:5501")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        if(userService.login(loginDTO.getEmail(), loginDTO.getPassword())){
            session.setAttribute("email", loginDTO.getEmail());
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }
}
