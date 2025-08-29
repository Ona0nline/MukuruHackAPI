package mukuruRewards.example.mukuru_solutions.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@Data
public class WalletDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double balance;
    private double newBalance;
    private double credit;
    private double debit;
    private int userId;
    private int points_id;
    private LocalDateTime timestamp;


    public WalletDetails() {

    }

    public WalletDetails(double balance, double newBalance, double credit, double debit, int userId, int points_id, LocalDateTime localDateTime) {
        this.balance = balance;
        this.newBalance = newBalance;
        this.credit = credit;
        this.debit = debit;
        this.userId = userId;
        this.points_id = points_id;
        this.timestamp = localDateTime;
    }
}
