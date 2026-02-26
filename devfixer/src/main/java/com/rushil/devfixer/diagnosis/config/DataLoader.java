package com.rushil.devfixer.diagnosis.config;

import com.rushil.devfixer.diagnosis.model.ErrorSolution;
import com.rushil.devfixer.diagnosis.repository.ErrorSolutionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ErrorSolutionRepository repository) {
        return args -> {

            // insert only if database is empty
            if (repository.count() == 0) {

                ErrorSolution error1 = new ErrorSolution(
                        "NullPointerException",
                        "Object is null when accessed",
                        "Check object initialization before use"
                );

                ErrorSolution error2 = new ErrorSolution(
                        "Cannot connect to localhost",
                        "Server not running",
                        "Start Spring Boot application or check port"
                );

                repository.save(error1);
                repository.save(error2);

                System.out.println("✅ DevFixer knowledge loaded!");
            }
        };
    }
}