package pl.project.carDealer.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.carDealer.Services.CarServices;
import pl.project.carDealer.model.Car;


import java.util.List;

@Controller
@RequestMapping( "/cars" )
public class CarControllers {

    public final CarServices carServices;


    @Autowired
    public CarControllers(CarServices carServices) {
        this.carServices = carServices;
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<Car> cars = carServices.findAll();
        model.addAttribute("cars",cars);
        return "car/list";

    }
    @GetMapping("/{id}/edit")
    public String ShowEditorCar(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carServices.getCar(id));
        return "car/add";
    }
    @GetMapping("/{id}/details")
    public String ShowDetailsCar(@PathVariable("id") Integer id, Model model){
        model.addAttribute("car", carServices.getCar(id));
        return "car/details";
    }

    @GetMapping ("/add")
    public String showAddCar (Model model){
        model.addAttribute("car", new Car());
        return "car/add";
    }
    @PostMapping("/save")
    public String addCar(@ModelAttribute("car") Car car) {
        carServices.save(car);
        return "redirect:/car/list";
    }



}
