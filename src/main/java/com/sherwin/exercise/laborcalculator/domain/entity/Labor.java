package com.sherwin.exercise.laborcalculator.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="labor")
public class LaborCalculated {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double length;
    private double width;
    @Column(name="price_per_sqft")
    private double pricePerSqft;
    @Column(name="total_price")
    private double price;
    Date createdAt;

//    public LaborCalculated(double price, double length, double width, double pricePerSqft){
//        this.length = length;
//        this.width = width;
//        this.pricePerSqft = pricePerSqft;
//        this.price = price;
//        this.createdAt = new Date();
//    }

}
