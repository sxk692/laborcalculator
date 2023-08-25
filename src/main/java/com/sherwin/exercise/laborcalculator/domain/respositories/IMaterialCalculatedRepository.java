package com.sherwin.exercise.laborcalculator.domain.respositories;

import com.sherwin.exercise.laborcalculator.domain.entity.MaterialCalculated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaterialCalculatedRepository extends JpaRepository<MaterialCalculated, Integer> {

}
