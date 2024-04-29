package com.codecool.rest.services.impl;

import com.codecool.rest.entites.CarSpeedInformation;
import com.codecool.rest.repositories.CarSpeedInformationRepository;
import com.codecool.rest.services.CarSpeedInformationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.codecool.rest.entites.CarSpeedInformation.createCarSpeedInformationFrom;

@Service
@AllArgsConstructor
public class CarSpeedInformationServiceImpl implements CarSpeedInformationService {

    private CarSpeedInformationRepository carSpeedInformationRepository;

    @Override
    public List<CarSpeedInformation> getAllRecords() {
        return carSpeedInformationRepository.findAll();
    }

    @Override
    public CarSpeedInformation addCarSpeedRecord(CarSpeedInformation carSpeedInformation) {
        if (carSpeedInformation == null) {
            throw new IllegalArgumentException("The object that is being saved cannot be null");
        }

        return carSpeedInformationRepository.save(carSpeedInformation);
    }

    @Override
    public List<CarSpeedInformation> loadRecordsFromLocalFile() throws FileNotFoundException {
        List<CarSpeedInformation> carSpeedInformations = new ArrayList<>();
        File dataFile = new File("src/main/resources/measurements.txt");
        Scanner fileScanner = new Scanner(dataFile);
        while (fileScanner.hasNextLine()) {
            CarSpeedInformation carSpeedInformation = createCarSpeedInformationFrom(fileScanner.nextLine());
            carSpeedInformations.add(carSpeedInformationRepository.save(carSpeedInformation));
        }
        fileScanner.close();
        return carSpeedInformations;
    }
}
