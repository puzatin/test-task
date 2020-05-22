package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;

import com.mcb.creditfactory.model.assessment.AirplaneAssessment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private int fuelCapacity;
    private int seats;
    private Short year;
    private Set<AirplaneAssessment> values;
}
