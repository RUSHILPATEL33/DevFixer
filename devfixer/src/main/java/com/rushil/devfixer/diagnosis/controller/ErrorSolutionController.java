package com.rushil.devfixer.diagnosis.controller;

import com.rushil.devfixer.diagnosis.dto.DiagnosisRequest;
import com.rushil.devfixer.diagnosis.model.ErrorSolution;
import com.rushil.devfixer.diagnosis.service.ErrorSolutionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diagnosis")
public class ErrorSolutionController {

    private final ErrorSolutionService errorSolutionService;

    public ErrorSolutionController(ErrorSolutionService errorSolutionService) {
        this.errorSolutionService = errorSolutionService;
    }

    @GetMapping
    public List<ErrorSolution> getAllSolutions(){
        return errorSolutionService.getAllSolutions();
    }

    @GetMapping("/")
    public String home() {
        return "DevFixer API is running 🚀";
    }

    @PostMapping("/search")
    public ErrorSolution diagnose(@Valid @RequestBody DiagnosisRequest request) {
        return errorSolutionService.findByErrorName(request.getErrorName());
    }
}