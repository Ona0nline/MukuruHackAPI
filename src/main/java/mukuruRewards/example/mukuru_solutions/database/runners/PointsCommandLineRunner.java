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
        pointsDetails.add(new PointsDetails(500, 100, 50, 550, 1));
        pointsDetails.add(new PointsDetails(300, 0, 75, 225, 2));
        pointsDetails.add(new PointsDetails(1200, 200, 150, 1250, 3));
        pointsDetails.add(new PointsDetails(50, 20, 0, 70, 4));
        pointsDetails.add(new PointsDetails(750, 0, 300, 450, 5));
        pointsDetails.add(new PointsDetails(400, 50, 25, 425, 6));
        pointsDetails.add(new PointsDetails(60, 0, 10, 50, 7));
        pointsDetails.add(new PointsDetails(2000, 500, 1000, 1500, 8));
        pointsDetails.add(new PointsDetails(150, 25, 0, 175, 9));
        pointsDetails.add(new PointsDetails(800, 0, 400, 400, 10));

//        pointsDetails.add(new PointsDetails(200,1));

    }
    @Override
    public void run(String... args) throws Exception {
        pointsRepo.deleteAll();
        pointsRepo.saveAll(pointsDetails);

    }
}
