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
        walletDetails.add(new WalletDetails(5000.45, 4950.45, 0.0, 50.0, 1, 1, LocalDateTime.of(2025, 8, 29, 11, 5, 2)));
        walletDetails.add(new WalletDetails(200.90, 350.90, 150.00, 0.0, 2, 2, LocalDateTime.of(2025, 8, 29, 12, 13, 12)));
        walletDetails.add(new WalletDetails(975.45, 975.45, 0.0, 0.0, 3, 3, LocalDateTime.of(2025, 8, 29, 13, 38, 20)));
        walletDetails.add(new WalletDetails(1200.00, 1100.00, 100.0, 0.0, 4, 4, LocalDateTime.of(2025, 8, 29, 14, 10, 45)));
        walletDetails.add(new WalletDetails(450.75, 650.75, 0.0, 200.0, 5, 5, LocalDateTime.of(2025, 8, 29, 15, 25, 33)));
        walletDetails.add(new WalletDetails(800.30, 700.30, 100.0, 0.0, 6, 6, LocalDateTime.of(2025, 8, 29, 16, 40, 10)));
        walletDetails.add(new WalletDetails(300.00, 500.00, 0.0, 200.0, 7, 7, LocalDateTime.of(2025, 8, 29, 17, 55, 5)));
        walletDetails.add(new WalletDetails(1500.00, 1300.00, 200.0, 0.0, 8, 8, LocalDateTime.of(2025, 8, 29, 18, 20, 48)));
        walletDetails.add(new WalletDetails(250.25, 250.25, 0.0, 0.0, 9, 9, LocalDateTime.of(2025, 8, 29, 19, 30, 27)));
        walletDetails.add(new WalletDetails(600.00, 700.00, 0.0, 100.0, 10, 10, LocalDateTime.of(2025, 8, 29, 20, 45, 15)));

    }


    @Override
    public void run(String... args) throws Exception {
//        if (walletRepo.count() == 0) {
            // Save demo data only when the db is empty
        walletRepo.deleteAll();
            walletRepo.saveAll(walletDetails);
//        }
    }
}
