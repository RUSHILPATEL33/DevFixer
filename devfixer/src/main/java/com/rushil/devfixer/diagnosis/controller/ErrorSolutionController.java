package com.rushil.devfixer.diagnosis.controller;

import com.rushil.devfixer.diagnosis.dto.DiagnosisRequest;
import com.rushil.devfixer.diagnosis.dto.DiagnosisResponse;
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

    // ✅ INSERT NEW SOLUTION
    @PostMapping
    public ErrorSolution addSolution(@RequestBody ErrorSolution solution) {
        return errorSolutionService.saveSolution(solution);
    }

    // ✅ GET ALL
    @GetMapping
    public List<ErrorSolution> getAllSolutions(){
        return errorSolutionService.getAllSolutions();
    }

    // ✅ SEARCH
    @PostMapping("/search")
    public DiagnosisResponse diagnose(@Valid @RequestBody DiagnosisRequest request) {
        return errorSolutionService.diagnoseError(request.getErrorName());
    }

    // ✅ HEALTH CHECK
    @GetMapping("/")
    public String home() {
        return "DevFixer API is running 🚀";
    }
}