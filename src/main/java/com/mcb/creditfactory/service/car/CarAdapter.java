package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.assessment.CarAssessment;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {

    private CarDto car;

    @Override
    public BigDecimal getValue() {
        return getLastAssessment().getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }


    private CarAssessment getLastAssessment() {
        Comparator<CarAssessment> comparator = Comparator.comparing(CarAssessment::getAssessDate, ChronoLocalDate.timeLineOrder());
        return car.getValues().stream().max(comparator).get();

    }
}
