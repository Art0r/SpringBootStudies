package com.example.demo.services;

import com.example.demo.models.Example;

import java.util.List;
import java.util.Optional;

public interface IExampleService {
    Optional<Example> retrieveExampleById(Integer id);
    List<Example> retrieveExamples();
    void createExample(Example example);
}
