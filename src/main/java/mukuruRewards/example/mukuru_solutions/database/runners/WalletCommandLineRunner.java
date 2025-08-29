package mukuruRewards.example.mukuru_solutions.database.runners;

import mukuruRewards.example.mukuru_solutions.database.details.WalletDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class WalletCommandLineRunner implements CommandLineRunner {
    @Autowired
    private WalletRepo walletRepo;

    private static List<WalletDetails> walletDetails = new ArrayList<>();

    static {
        walletDetails.add(new WalletDetails(5000.45, 4950.45,0.0,50,1,1, LocalDateTime.of(2025, 8, 29, 11, 5, 2)));
        walletDetails.add(new WalletDetails(200.90,350.90,150.00,0,2,2, LocalDateTime.of(2025, 8, 29, 12, 13, 12)));
        walletDetails.add(new WalletDetails(975.45, 975.45,0.0,0.0,3,3, LocalDateTime.of(2025, 8, 29, 13, 38, 20)));

    }


    @Override
    public void run(String... args) throws Exception {
        if (walletRepo.count() == 0) {
            // Save demo data only when the db is empty
            walletRepo.saveAll(walletDetails);
        }
    }
}
