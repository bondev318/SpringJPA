package com.jetbrains.employeedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDemoApplication.class, args);
    }
    // Save
    private void insertFourEmployees(EmployeeRepository repository){
        repository.save(new Employee("Dai", "Quyen"));
        repository.save(new Employee("Nhat", "Hoang"));
        repository.save(new Employee("The", "Hau"));
        repository.save(new Employee("Huu", "Hien"));

    }
    @Bean
    public CommandLineRunner run(EmployeeRepository repository) {
        return (args) -> {
            insertFourEmployees(repository);
            System.out.println(repository.findAll());
            System.out.println(repository.findEmployeesByLastNameContaining("Quyen"));

        };
    }
}
