package com.sherwin.exercise.laborcalculator.domain.respositories;

import com.sherwin.exercise.laborcalculator.domain.entity.Labor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILaborRepository extends JpaRepository<Labor, Integer> {
}
