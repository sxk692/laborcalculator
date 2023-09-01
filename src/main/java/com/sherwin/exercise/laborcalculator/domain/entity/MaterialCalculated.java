package com.sherwin.exercise.laborcalculator.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="material")
public class MaterialCalculated {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    Date createdAt;
    @Min(0)
    private double length;
    @Min(0)
    private double width;
    @Min(0)
    private double sqftPerGallon;
    @Min(0)
    private double gallonsRequired;

    public MaterialCalculated(double length, double width, double sqftPerGallon, double gallonsRequired){
        this.length = length;
        this.width = width;
        this.sqftPerGallon = sqftPerGallon;
        this.gallonsRequired = gallonsRequired;
        this.createdAt = new Date();
    }
}
