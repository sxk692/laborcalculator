package com.sherwin.exercise.laborcalculator.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double length;
    private double width;
    @Column(name = "sqft_per_gallon")
    private double sqftPerGallon;
    @Column(name = "gallons_required")
    private double gallonsRequired;
    Date createdAt;
}
