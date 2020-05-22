package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarCollateralService implements CollateralService {

    @Autowired
    private CarService carService;

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {

            CarDto carDto = (CarDto) object;
            boolean approved = carService.approve(carDto);
            if (!approved) {
                return null;
            }

            return Optional.of(carDto)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);

    }

    public Collateral getInfo(Collateral object) {

        return Optional.of((CarDto) object)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::load)
                .map(carService::toDTO)
                .orElse(null);
    }
}
