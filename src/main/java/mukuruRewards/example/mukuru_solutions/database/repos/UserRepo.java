package mukuruRewards.example.mukuru_solutions.database.repos;

import mukuruRewards.example.mukuru_solutions.database.details.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmail(String email);
    Optional<UserDetails> findByName(String name);

}
