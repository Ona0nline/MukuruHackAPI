package mukuruRewards.example.mukuru_solutions.services;

import mukuruRewards.example.mukuru_solutions.dataTransferObjects.SignUpDTO;
import mukuruRewards.example.mukuru_solutions.database.details.UserDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public boolean login(String email, String password){
        UserDetails databaseUserDetails = userRepo.findByEmail(email);
        return Objects.equals(databaseUserDetails.getPassword(), password);
    }

    public SignUpDTO signup(SignUpDTO signUpDTO) {
        try {
            try {
                var userDetailsToInsert = UserDetails.builder()
                        .name(signUpDTO.getUsername())
                        .email(signUpDTO.getEmail())
                        .password(signUpDTO.getPassword()).build();

                userRepo.save(userDetailsToInsert);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        Returned data transfer object just to make sure it's formatted correctly incase we encounter errors
        return signUpDTO;
    }
}
