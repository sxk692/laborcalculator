package com.sherwin.exercise.laborcalculator.domain.respositories;

import com.sherwin.exercise.laborcalculator.domain.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaterialRepository extends JpaRepository<Material, Integer> {

}
