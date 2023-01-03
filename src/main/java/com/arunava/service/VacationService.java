package com.arunava.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.arunava.model.Vacation;

public interface VacationService {
    ResponseEntity<?> saveVacation(Vacation vacation);

    ResponseEntity<?> getVacation();

    ResponseEntity<?> getVacationById(Long id);

    ResponseEntity<?> deleteVacationById(Long id);


    ResponseEntity<?> updateVacation(Long id, Vacation vacation);

    ResponseEntity<?> updateVacationField(Long id, Map<String, Object> fields);
}
