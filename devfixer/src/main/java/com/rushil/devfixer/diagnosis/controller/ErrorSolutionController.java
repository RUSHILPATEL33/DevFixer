package com.rushil.devfixer.diagnosis.controller;

import com.rushil.devfixer.diagnosis.model.ErrorSolution;
import com.rushil.devfixer.diagnosis.service.ErrorSolutionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/diagnosis")
public class ErrorSolutionController {
    private final ErrorSolutionService service;

    public ErrorSolutionController(ErrorSolutionService service) {
        this.service = service;
    }
    @GetMapping
    public List<ErrorSolution> getAllSolutions(){
        return service.getAllSolutions();
    }
    @GetMapping("/search")
    public ErrorSolution getSolution(@RequestParam String error){
        return service.findByErrorName(error);
    }
    @GetMapping("/")
    public String home() {
        return "DevFixer API is running 🚀";
    }
    @PostMapping
    public ErrorSolution addSolution(@RequestBody ErrorSolution solution){
        return service.saveSolution(solution);
    }
}
