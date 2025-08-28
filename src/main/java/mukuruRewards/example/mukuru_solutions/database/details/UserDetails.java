package mukuruRewards.example.mukuru_solutions.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private int wallet_id;

    public UserDetails() {

    }

    public UserDetails(String name, String email, int wallet_id){
        this.name = name;
        this.email = email;
        this.wallet_id = wallet_id;
    }
}
