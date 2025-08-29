package mukuruRewards.example.mukuru_solutions.services;

import mukuruRewards.example.mukuru_solutions.database.details.PointsDetails;
import mukuruRewards.example.mukuru_solutions.database.details.WalletDetails;
import mukuruRewards.example.mukuru_solutions.database.repos.PointsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointsService {

    @Autowired
    private WalletService walletService;

    @Autowired
    private PointsRepo pointsRepo;

//    public int addPoints(int amount, Long user_id){
//        PointsDetails pointsDetails = pointsRepo.findByUserId(user_id);
//    }
}
