package com.sherwin.exercise.laborcalculator.domain.respositories;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaborCalculatorRepository extends JpaRepository<LaborCalculated, Id> {

}
