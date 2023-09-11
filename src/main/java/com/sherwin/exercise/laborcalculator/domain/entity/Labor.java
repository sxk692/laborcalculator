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
public class Labor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double length;
    private double width;
    @Column(name="price_per_sqft")
    private double pricePerSqft;
    @Column(name="total_price")
    private double price;
    Date createdAt;
}
