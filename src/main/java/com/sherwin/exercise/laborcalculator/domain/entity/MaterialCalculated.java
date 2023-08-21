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
public class MaterialCalculated {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    Date createdAt;
    public double length;
    public double width;
    public double sqftPerGallon;

}
