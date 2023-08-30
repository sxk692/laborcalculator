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
@Table(name="labor")
public class LaborCalculated {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Min(0)
    public double length;
    @Min(0)
    public double width;
    @Column(name="price_per_sqft")
    @Min(0)
    public double pricePerSqft;
    @Column(name="total_price")
    @Min(0)
    public double price;
    Date createdAt;

    public LaborCalculated(double price, double length, double width, double pricePerSqft){
        this.length = length;
        this.width = width;
        this.pricePerSqft = pricePerSqft;
        this.price = price;
        this.createdAt = new Date();
    }

}
