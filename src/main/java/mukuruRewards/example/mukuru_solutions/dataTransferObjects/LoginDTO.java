package mukuruRewards.example.mukuru_solutions.dataTransferObjects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "Email is required.")
    @Email
    private String email;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, message = "Password must not be less than 8 characters.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")
    private String password;
}
