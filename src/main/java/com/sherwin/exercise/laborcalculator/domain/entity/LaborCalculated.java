package com.sherwin.exercise.laborcalculator.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="labor")
public class LaborCalculated {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public double length;
    public double width;
    @Column(name="price_per_sqft")
    public double pricePerSqft;
    @Column(name="total_price")
    //TODO use currency instead of price for database representation
    public double price;
    Date createdAt;

    public LaborCalculated(int id, double price, double length, double width, double pricePerSqft){
        this.id = id;
        this.length = length;
        this.width = width;
        this.pricePerSqft = pricePerSqft;
        this.price = price;
        this.createdAt = new Date();
    }

}
