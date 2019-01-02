package pl.project.carDealer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.carDealer.model.Car;

public interface CarRepositories extends JpaRepository<Car, Integer> {
}
