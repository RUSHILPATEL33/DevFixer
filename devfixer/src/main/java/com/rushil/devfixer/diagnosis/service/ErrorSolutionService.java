package com.rushil.devfixer.diagnosis.service;

import com.rushil.devfixer.common.ResourceNotFoundException;
import com.rushil.devfixer.diagnosis.model.ErrorSolution;
import com.rushil.devfixer.diagnosis.repository.ErrorSolutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorSolutionService {
    private final ErrorSolutionRepository repository;

    public ErrorSolutionService(ErrorSolutionRepository repository) {
        this.repository = repository;
    }
    public List<ErrorSolution> getAllSolutions(){
        return repository.findAll();
    }

    public ErrorSolution findByErrorName(String errorName) {
        return repository.findFirstByErrorPatternIgnoreCase(errorName)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No solution found for: " + errorName));
    }
    public ErrorSolution saveSolution(ErrorSolution solution){
        return repository.save(solution);
    }
}
