package mukuruRewards.example.mukuru_solutions.database.runners;

import mukuruRewards.example.mukuru_solutions.database.details.PointsDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.PointsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PointsCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PointsRepo pointsRepo;

    private static List<PointsDetails> pointsDetails = new ArrayList<>();
    static {
        pointsDetails.add(new PointsDetails(200,1));
        pointsDetails.add(new PointsDetails(1000,2));
        pointsDetails.add(new PointsDetails(10,3));
//        pointsDetails.add(new PointsDetails(200,1));

    }
    @Override
    public void run(String... args) throws Exception {
        pointsRepo.saveAll(pointsDetails);

    }
}
