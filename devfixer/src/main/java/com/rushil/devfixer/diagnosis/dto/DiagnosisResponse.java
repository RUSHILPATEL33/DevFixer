package com.rushil.devfixer.diagnosis.dto;

public class DiagnosisResponse {

    private String errorMatched;
    private String solution;
    private String message;

    public DiagnosisResponse(String errorMatched, String solution, String message) {
        this.errorMatched = errorMatched;
        this.solution = solution;
        this.message = message;
    }

    public String getErrorMatched() {
        return errorMatched;
    }

    public String getSolution() {
        return solution;
    }

    public String getMessage() {
        return message;
    }
}