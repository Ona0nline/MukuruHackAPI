package mukuruRewards.example.mukuru_solutions.controllors;

import mukuruRewards.example.mukuru_solutions.dataTransferObjects.LoginDTO;
import mukuruRewards.example.mukuru_solutions.dataTransferObjects.SignUpDTO;
import mukuruRewards.example.mukuru_solutions.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserService userService;

    public ResponseEntity<?> signup(SignUpDTO signUpDTO){
        return ResponseEntity.ok(userService.login(signUpDTO.getEmail(), signUpDTO.getPassword()));
    }

    public ResponseEntity<?> login(LoginDTO loginDTO){
        return ResponseEntity.ok(userService.login(loginDTO.getEmail(), loginDTO.getPassword()));
    }
}
