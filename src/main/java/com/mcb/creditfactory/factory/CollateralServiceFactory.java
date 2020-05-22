package com.mcb.creditfactory.factory;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.collateral.AirplaneCollateralService;
import com.mcb.creditfactory.service.collateral.CarCollateralService;
import com.mcb.creditfactory.service.collateral.CollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollateralServiceFactory {

    @Autowired
    private AirplaneCollateralService airplaneCollateralService;

    @Autowired
    private CarCollateralService carCollateralService;

    public CollateralService getService(Collateral collateral) {

        if (collateral instanceof CarDto) {
            return carCollateralService;
        }

        if (collateral instanceof AirplaneDto) {
            return airplaneCollateralService;
        }

        throw new IllegalArgumentException();
    }
}