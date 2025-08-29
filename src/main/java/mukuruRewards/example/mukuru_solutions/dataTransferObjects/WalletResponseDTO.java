package mukuruRewards.example.mukuru_solutions.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponseDTO {
    private String recepient_name;
    private double amount;
    private double credit;
    private double debit;
    private double prev_balance;
    private double curr_balance;

}
