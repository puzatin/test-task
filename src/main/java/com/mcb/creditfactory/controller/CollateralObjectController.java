package com.mcb.creditfactory.controller;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.factory.CollateralServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollateralObjectController {
    @Autowired
    private CollateralServiceFactory serviceFactory;

    @PostMapping("/collateral/save")
    public HttpEntity<Long> save(@RequestBody Collateral object) {
        Long id = serviceFactory.getService(object).saveCollateral(object);
        return id != null ? ResponseEntity.ok(id) : ResponseEntity.badRequest().build();
    }

    @PostMapping("/collateral/info")
    public HttpEntity<Collateral> getInfo(@RequestBody Collateral object) {
        Collateral info = serviceFactory.getService(object).getInfo(object);
        return info != null ? ResponseEntity.ok(info) : ResponseEntity.notFound().build();
    }
}
