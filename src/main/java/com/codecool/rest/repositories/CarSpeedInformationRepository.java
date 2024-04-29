package com.codecool.rest.repositories;

import com.codecool.rest.entites.CarSpeedInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarSpeedInformationRepository extends JpaRepository<CarSpeedInformation, UUID> {
}
