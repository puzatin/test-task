package com.mcb.creditfactory.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
@Slf4j
public class ExternalApproveService {
    private static final LocalDate MIN_ASSESS_DATE = LocalDate.of(2017, Month.OCTOBER, 1);
    private static final int MIN_CAR_YEAR = 2000;
    private static final BigDecimal MIN_CAR_VALUE = BigDecimal.valueOf(1000000);
    private static final int MIN_PLANE_YEAR = 1991;
    private static final BigDecimal MIN_PLANE_VALUE = BigDecimal.valueOf(230000000);


    public int approve(CollateralObject object) {

        // вынес в отдельные переменные чтобы избежать двойного вызова
        BigDecimal value = object.getValue();
        LocalDate date = object.getDate();
        Short year = object.getYear();
        CollateralType type = object.getType();

        if (date == null || year == null || value == null || type == null) {
            return -1;
        }

        int code;
        switch (type) {
            case CAR: code = approveCar(year, date, value); break;
            case AIRPLANE: code = approvePlane(year, date, value); break;
            default: code = -100;
        }

        return code;
    }

    private int approveCar(Short year, LocalDate date, BigDecimal value) {
        if (year < MIN_CAR_YEAR) {
            return -10;
        }
        if (date.isBefore(MIN_ASSESS_DATE)) {
            return -11;
        }
        if (value.compareTo(MIN_CAR_VALUE) < 0) {
            return -12;
        }

        return 0;
    }

    private int approvePlane(Short year, LocalDate date, BigDecimal value) {
        if (year < MIN_PLANE_YEAR) {
            return -20;
        }
        if (date.isBefore(MIN_ASSESS_DATE)) {
            return -21;
        }
        if (value.compareTo(MIN_PLANE_VALUE) < 0) {
            return -22;
        }

        return 0;
    }
}
