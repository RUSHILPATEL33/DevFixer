package com.rushil.devfixer.diagnosis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "error_solution")
public class ErrorSolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String errorPattern;
    private String description;
    private String solution;

    public ErrorSolution(){}
    public ErrorSolution(String errorPattern, String description, String solution) {
        this.errorPattern = errorPattern;
        this.description = description;
        this.solution = solution;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getErrorPattern() {
        return errorPattern;
    }

    public void setErrorPattern(String errorPattern) {
        this.errorPattern = errorPattern;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
