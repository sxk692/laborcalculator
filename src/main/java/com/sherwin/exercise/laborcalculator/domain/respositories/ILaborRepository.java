package com.sherwin.exercise.laborcalculator.domain.respositories;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaborCalculatedRepository extends JpaRepository<Labor, Integer> {

}
