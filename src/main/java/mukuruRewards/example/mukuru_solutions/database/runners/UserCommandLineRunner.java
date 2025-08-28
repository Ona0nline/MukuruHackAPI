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
        userDetails.add(new UserDetails("Lebogang Aphane", "leaphane@gmail.com", 1));
        userDetails.add(new UserDetails("Naledi Khumalo", "naledi.khumalo@gmail.com", 2));
        userDetails.add(new UserDetails("Sibusiso Mokoena", "sibusiso.mokoena@gmail.com", 3));
        userDetails.add(new UserDetails("Thandiwe Dlamini", "thandiwe.dlamini@gmail.com", 4));
        userDetails.add(new UserDetails("Kgosi Molefe", "kgosi.molefe@gmail.com", 5));
        userDetails.add(new UserDetails("Zanele Nkosi", "zanele.nkosi@gmail.com", 6));
        userDetails.add(new UserDetails("Bongani Shabalala", "bongani.shabalala@gmail.com", 7));
        userDetails.add(new UserDetails("Lerato Mahlangu", "lerato.mahlangu@gmail.com", 8));
        userDetails.add(new UserDetails("Mpho Sebe", "mpho.sebe@gmail.com", 9));
        userDetails.add(new UserDetails("Karabo Radebe", "karabo.radebe@gmail.com", 10));
    }


    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll(userDetails);
        userRepo.saveAll(userDetails);
    }
}
