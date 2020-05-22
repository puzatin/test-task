package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirplaneCollateralService implements CollateralService {

    @Autowired
    private AirplaneService airplaneService;

    @Override
    public Long saveCollateral(Collateral object) {
        AirplaneDto airplaneDto = (AirplaneDto) object;
        boolean approved = airplaneService.approve(airplaneDto);

        if (!approved) {
            return null;
        }

        return Optional.of(airplaneDto)
                .map(airplaneService::fromDto)
                .map(airplaneService::save)
                .map(airplaneService::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(Collateral object) {
        return Optional.of((AirplaneDto) object)
                .map(airplaneService::fromDto)
                .map(airplaneService::getId)
                .flatMap(airplaneService::load)
                .map(airplaneService::toDTO)
                .orElse(null);
    }
}
