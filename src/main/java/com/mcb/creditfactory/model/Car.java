package com.mcb.creditfactory.model;

import com.mcb.creditfactory.model.assessment.CarAssessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Double power;

    @Column(name = "year_of_issue")
    private Short year;

    @ElementCollection
    @CollectionTable(name = "CAR_ASSESSMENT", joinColumns = @JoinColumn(name = "car_id"))
    private Set<CarAssessment> values;
}
