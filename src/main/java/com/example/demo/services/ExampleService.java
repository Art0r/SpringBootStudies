package com.example.demo.services;

import com.example.demo.models.Example;
import com.example.demo.repositories.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService implements IExampleService {

    private final ExampleRepository exampleRepository;

    @Autowired
    public ExampleService(ExampleRepository exampleRepository) {
        this.exampleRepository = exampleRepository;
    }

    public List<Example> retrieveExamples() {
        return this.exampleRepository.findAll();
    }

    public Optional<Example> retrieveExampleById(Integer id) {
        return this.exampleRepository.findById(id);
    }

    public void createExample(Example example) {
        this.exampleRepository.save(example);
    }
}
