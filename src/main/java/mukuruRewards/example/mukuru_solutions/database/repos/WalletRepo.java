package mukuruRewards.example.mukuru_solutions.database.repos;

import mukuruRewards.example.mukuru_solutions.database.details.WalletDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepo extends JpaRepository<WalletDetails, Long> {
    WalletDetails findByUserId(Long userId);
}
