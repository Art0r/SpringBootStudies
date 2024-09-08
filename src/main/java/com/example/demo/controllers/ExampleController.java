package com.example.demo.controllers;

import com.example.demo.models.Example;
import com.example.demo.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ExampleController {

    private final ExampleService exampleService;

    @Autowired
    public ExampleController(final ExampleService exampleService) {
        this.exampleService = exampleService;
    }


    @GetMapping("")
    public ResponseEntity<List<Example>> getAll() {
        List<Example> examples = exampleService.retrieveExamples();
        return new ResponseEntity<>(examples, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Example> getOne(@PathVariable(required = true) Integer id) {
        Optional<Example> example = exampleService.retrieveExampleById(id);
        return example.map(value ->
                new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody Example requestBody) {
        try {
            exampleService.createExample(requestBody);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
