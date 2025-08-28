package mukuruRewards.example.mukuru_solutions.database.runners;

import mukuruRewards.example.mukuru_solutions.database.details.WalletDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WalletCommandLineRunner implements CommandLineRunner {
    @Autowired
    private WalletRepo walletRepo;

    private static List<WalletDetails> walletDetails = new ArrayList<>();

    static {
        walletDetails.add(new WalletDetails(5000.45,0.0,50,1,1));
        walletDetails.add(new WalletDetails(200.90,150.00,0,2,2));
        walletDetails.add(new WalletDetails(975.45,0.0,0.0,3,3));

    }


    @Override
    public void run(String... args) throws Exception {
        walletRepo.deleteAll();
        walletRepo.saveAll(walletDetails);
    }
}
