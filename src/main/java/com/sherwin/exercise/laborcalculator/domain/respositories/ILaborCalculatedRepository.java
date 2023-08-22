package com.sherwin.exercise.laborcalculator.domain.respositories;

import com.sherwin.exercise.laborcalculator.domain.entity.LaborCalculated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaborCalculatedRepository extends JpaRepository<LaborCalculated, Integer> {

}
