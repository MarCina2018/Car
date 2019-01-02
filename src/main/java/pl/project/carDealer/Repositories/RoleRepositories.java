package pl.project.carDealer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carDealer.model.Role;

public interface RoleRepositories extends JpaRepository<Role, Integer> {
}
