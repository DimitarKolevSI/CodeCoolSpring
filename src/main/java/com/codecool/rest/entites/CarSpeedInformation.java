package com.codecool.rest.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "car_speed_information")
public class CarSpeedInformation {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    UUID id;

    @Column(name = "plate_number")
    String plateNumber;

    @Column(name = "enter_hours")
    int enterHours;

    @Column(name = "enter_minutes")
    int enterMinutes;

    @Column(name = "enter_seconds")
    int enterSeconds;

    @Column(name = "enter_milliseconds")
    int enterMilliseconds;

    @Column(name = "exit_hours")
    int exitHours;

    @Column(name = "exit_minutes")
    int exitMinutes;

    @Column(name = "exit_seconds")
    int exitSeconds;

    @Column(name = "exit_milliseconds")
    int exitMilliseconds;

    public static CarSpeedInformation createCarSpeedInformationFrom(String textFileLine) {
        String[] numbers = textFileLine.split(" ");
        CarSpeedInformation speedInformation = new CarSpeedInformation();
        speedInformation.plateNumber = numbers[0];
        speedInformation.enterHours = Integer.parseInt(numbers[1]);
        speedInformation.enterMinutes = Integer.parseInt(numbers[2]);
        speedInformation.enterSeconds = Integer.parseInt(numbers[3]);
        speedInformation.enterMilliseconds = Integer.parseInt(numbers[4]);
        speedInformation.exitHours = Integer.parseInt(numbers[5]);
        speedInformation.exitMinutes = Integer.parseInt(numbers[6]);
        speedInformation.exitSeconds = Integer.parseInt(numbers[7]);
        speedInformation.exitMilliseconds = Integer.parseInt(numbers[8]);
        return speedInformation;
    }
}
