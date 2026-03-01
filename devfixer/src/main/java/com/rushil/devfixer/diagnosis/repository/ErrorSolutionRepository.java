package com.rushil.devfixer.diagnosis.repository;

import com.rushil.devfixer.diagnosis.model.ErrorSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ErrorSolutionRepository extends JpaRepository<ErrorSolution, Long> {
    Optional<ErrorSolution> findFirstByErrorPatternIgnoreCase(String errorPattern);
    @Query("SELECT e FROM ErrorSolution e WHERE LOWER(:input) LIKE LOWER(CONCAT('%', e.errorPattern, '%'))")
    Optional<ErrorSolution> findMatchingSolution(@Param("input") String input);
}