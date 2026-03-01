package com.rushil.devfixer.diagnosis.service;

import com.rushil.devfixer.common.ResourceNotFoundException;
import com.rushil.devfixer.diagnosis.dto.DiagnosisResponse;
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

        String normalizedInput = errorName.toLowerCase().trim();

        List<ErrorSolution> matches =
                repository.findAllMatchingSolutions(normalizedInput);

        if (matches.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No matching solution found for: " + errorName);
        }

        return matches.stream()
                .max((a, b) ->
                        Integer.compare(
                                a.getErrorPattern().length(),
                                b.getErrorPattern().length()))
                .orElseThrow();
    }
    public ErrorSolution saveSolution(ErrorSolution solution){
        return repository.save(solution);
    }
    public DiagnosisResponse diagnoseError(String errorName) {

        String normalizedInput = errorName.toLowerCase().trim();

        List<ErrorSolution> matches =
                repository.findAllMatchingSolutions(normalizedInput);

        if (matches.isEmpty()) {
            throw new ResourceNotFoundException(
                    "No matching solution found for: " + errorName);
        }

        ErrorSolution bestMatch = matches.stream()
                .max((a, b) ->
                        Integer.compare(
                                a.getErrorPattern().length(),
                                b.getErrorPattern().length()))
                .orElseThrow();

        return new DiagnosisResponse(
                bestMatch.getErrorPattern(),
                bestMatch.getSolution(),
                "Solution found successfully"
        );
    }
}
