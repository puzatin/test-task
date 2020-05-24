package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Assessment;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
    private AirplaneDto airplane;

    @Override
    public BigDecimal getValue() {
        return  getLastAssessment().getValue();
    }

    @Override
    public Short getYear() {
        return airplane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return getLastAssessment().getAssessDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }

    private Assessment getLastAssessment() {
        Comparator<Assessment> comparator = Comparator.comparing(Assessment::getAssessDate, ChronoLocalDate.timeLineOrder());
        return airplane.getValues().stream().max(comparator).get();
    }
}

