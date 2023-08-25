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
@Table(name="material")
public class MaterialCalculated {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    Date createdAt;
    public double length;
    public double width;
    public double sqftPerGallon;
    public double gallonsRequired;

    public MaterialCalculated(double length, double width, double sqftPerGallon, double gallonsRequired){
        this.length = length;
        this.width = width;
        this.sqftPerGallon = sqftPerGallon;
        this.gallonsRequired = gallonsRequired;
        this.createdAt = new Date();
    }
}
