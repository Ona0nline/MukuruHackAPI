package mukuruRewards.example.mukuru_solutions.database.repos;

import mukuruRewards.example.mukuru_solutions.database.details.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
    UserDetails findByEmail(String email);
}
