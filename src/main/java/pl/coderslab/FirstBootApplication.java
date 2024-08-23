package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "pl.coderslab")
public class FirstBootApplication  {


     public static void main(String[] args) {
        SpringApplication.run(FirstBootApplication.class, args);
    }

}