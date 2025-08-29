package mukuruRewards.example.mukuru_solutions.database.repos;

import mukuruRewards.example.mukuru_solutions.database.details.PointsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRepo extends JpaRepository<PointsDetails, Long> {

}
