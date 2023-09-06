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
    Date createdAt;
    private double length;
    private double width;
    @Column(name = "sqft_per_gallon")
    private double sqftPerGallon;
    @Column(name = "gallons_required")
    private double gallonsRequired;

//    public Material(double length, double width, double sqftPerGallon, double gallonsRequired){
//        this.length = length;
//        this.width = width;
//        this.sqftPerGallon = sqftPerGallon;
//        this.gallonsRequired = gallonsRequired;
//        this.createdAt = new Date();
//    }
}
