package mukuruRewards.example.mukuru_solutions.database.runners;

import mukuruRewards.example.mukuru_solutions.database.details.UserDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;

    private static List<UserDetails> userDetails = new ArrayList<>();

    static {
        userDetails.add(new UserDetails("Lebogang Aphane", "leaphane@gmail.com", "password5$$L"));
        userDetails.add(new UserDetails("Naledi Khumalo", "naledi.khumalo@gmail.com", "KJDKJ&&76gshc"));
        userDetails.add(new UserDetails("Sibusiso Mokoena", "sibusiso.mokoena@gmail.com", "fjdjf88%%22"));
        userDetails.add(new UserDetails("Thandiwe Dlamini", "thandiwe.dlamini@gmail.com", "jfkNN88&&"));
        userDetails.add(new UserDetails("Kgosi Molefe", "kgosi.molefe@gmail.com", "ll((99yy"));
        userDetails.add(new UserDetails("Zanele Nkosi", "zanele.nkosi@gmail.com", "LLpp00##fd"));
        userDetails.add(new UserDetails("Bongani Shabalala", "bongani.shabalala@gmail.com", "NNkk55%%sds"));
        userDetails.add(new UserDetails("Lerato Mahlangu", "lerato.mahlangu@gmail.com", "fdfKKJD88&^&"));
        userDetails.add(new UserDetails("Mpho Sebe", "mpho.sebe@gmail.com", "flk::djdjIDID99"));
        userDetails.add(new UserDetails("Karabo Radebe", "karabo.radebe@gmail.com", "efijLDKL998**"));
    }


    @Override
    public void run(String... args) throws Exception {
        if (userRepo.count() == 0) {
            // Save demo data only when the db is empty
            userRepo.saveAll(userDetails);
        }
    }
}
