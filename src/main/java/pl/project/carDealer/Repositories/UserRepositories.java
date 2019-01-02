package pl.project.carDealer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carDealer.model.User;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

}
