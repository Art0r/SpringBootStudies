package com.example.demo;

import com.example.demo.models.Example;
import com.example.demo.repositories.ExampleRepository;
import com.example.demo.services.ExampleService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.demo.repositories")
public class Demo1Application {

    private ExampleService exampleService;

    public Demo1Application(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        Faker faker = new Faker();


        for (int i = 0; i < 10; i++) {
            Example example = new Example();
            String email = faker.internet().emailAddress();
            String name = faker.funnyName().name();

            example.setEmail(email);
            example.setName(name);

            exampleService.createExample(example);
        }
    }
}
