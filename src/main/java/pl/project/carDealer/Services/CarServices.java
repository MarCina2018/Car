package pl.project.carDealer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.carDealer.Repositories.CarRepositories;
import pl.project.carDealer.model.Car;

import java.util.List;

@Service
public class CarServices {

    public final CarRepositories carRepositories;


    @Autowired
    public CarServices (CarRepositories carRepositories){
        this.carRepositories = carRepositories;
    }

    public List<Car> findAll(){
        return carRepositories.findAll();
    }

    public Car getCar(Integer id) {
        return  carRepositories.findById(id).get();
    }

    public Car save (Car car){
        return carRepositories.save(car);
    }

}
