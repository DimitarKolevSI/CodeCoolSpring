package com.codecool.rest.services;

import com.codecool.rest.entites.CarSpeedInformation;

import java.io.FileNotFoundException;
import java.util.List;

public interface CarSpeedInformationService {

    List<CarSpeedInformation> getAllRecords();

    CarSpeedInformation addCarSpeedRecord(CarSpeedInformation carSpeedInformation);

    List<CarSpeedInformation> loadRecordsFromLocalFile() throws FileNotFoundException;
}
