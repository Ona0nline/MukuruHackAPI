package mukuruRewards.example.mukuru_solutions.controllors;

import mukuruRewards.example.mukuru_solutions.dataTransferObjects.LoginDTO;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.SignUpDTO;
import mukuruRewards.example.mukuru_solutions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpDTO signUpDTO){
        return ResponseEntity.ok(userService.signup(signUpDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        if(userService.login(loginDTO.getEmail(), loginDTO.getPassword())){
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(403).build();
    }
}
