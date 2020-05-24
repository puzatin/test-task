package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private int fuelCapacity;
    private int seats;

    @Column(name = "year_of_issue")
    private Short year;

    @ElementCollection
    @CollectionTable(name = "AIRPLANE_ASSESSMENT", joinColumns = @JoinColumn(name = "airplane_id"))
    private Set<Assessment> values;


}
