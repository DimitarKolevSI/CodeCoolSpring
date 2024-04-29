package com.codecool.rest.controllers;

import com.codecool.rest.entites.CarSpeedInformation;
import com.codecool.rest.services.CarSpeedInformationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("cars")
public class CarSpeedInformationController {

    private CarSpeedInformationService carSpeedInformationService;

    @GetMapping(value = "/all")
    public List<CarSpeedInformation> getAll() {
        return carSpeedInformationService.getAllRecords();
    }

    @PutMapping(value = "/add-record")
    public CarSpeedInformation addCarSpeedInformation(@RequestBody CarSpeedInformation carSpeedInformation) {
        return carSpeedInformationService.addCarSpeedRecord(carSpeedInformation);
    }

    @PutMapping(value = "/load-data")
    public List<CarSpeedInformation> loadDataFromLocalFile() throws FileNotFoundException {
        return carSpeedInformationService.loadRecordsFromLocalFile();
    }
}
