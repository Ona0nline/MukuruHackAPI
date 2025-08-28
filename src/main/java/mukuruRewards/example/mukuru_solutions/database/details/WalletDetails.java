package mukuruRewards.example.mukuru_solutions.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Builder
@AllArgsConstructor
@Data
public class WalletDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double balance;
    private double credit;
    private double debit;
    private int userId;
    private int points_id;


    public WalletDetails() {

    }

    public WalletDetails(double balance, double credit, double debit, int userId, int points_id) {
        this.balance = balance;
        this.credit = credit;
        this.debit = debit;
        this.userId = userId;
        this.points_id = points_id;
    }
}
