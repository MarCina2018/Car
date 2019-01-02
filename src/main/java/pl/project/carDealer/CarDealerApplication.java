package pl.project.carDealer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CarDealerApplication {

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("Cina"));
		SpringApplication.run(CarDealerApplication.class, args);
	}
}
