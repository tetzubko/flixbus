package flixbus.assignment;

import flixbus.assignment.model.BusCost;
import flixbus.assignment.model.Connection;
import flixbus.assignment.model.DriverCost;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication()
public class FlixBus {

    public static void main(String[] args) {
        SpringApplication.run(FlixBus.class, args);
    }

    @Bean
    CommandLineRunner runner (ModelStorage modelStorage, ConnectionRepository connectionRepository, BusCostRepository busCostRepository, DriverCostRepository driverCostRepository){
        return args -> {
            modelStorage.createSampleModel(connectionRepository,busCostRepository,driverCostRepository);
        };
    }
}