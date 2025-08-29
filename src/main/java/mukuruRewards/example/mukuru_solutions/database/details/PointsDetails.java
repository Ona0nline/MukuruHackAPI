package mukuruRewards.example.mukuru_solutions.database.details;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PointsDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int pointsBalance;
    private int credit;
    private int debit;
    private int newPointsBalance;
    private int user_id;

    public PointsDetails(int points, int credit, int debit, int newPointsBalance, int user_id) {
        this.pointsBalance = points;
        this.credit = credit;
        this.debit = debit;
        this.newPointsBalance = newPointsBalance;
        this.user_id = user_id;
    }


}
