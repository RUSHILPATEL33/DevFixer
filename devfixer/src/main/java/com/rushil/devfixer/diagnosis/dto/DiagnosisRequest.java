package com.rushil.devfixer.diagnosis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DiagnosisRequest {
    @NotBlank(message = "Error name must not be empty")
    @Size(min = 3, message = "Error name must be at least 3 characters")
    private String errorName;

    public String getErrorName(){
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }
}
