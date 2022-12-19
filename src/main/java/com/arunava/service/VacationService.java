package com.arunava.service;

import com.arunava.model.Vacation;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface VacationService {
    ResponseEntity<?> saveVacation(Vacation vacation);

    ResponseEntity<?> getVacation();

    ResponseEntity<?> getVacationById(Long id);

    ResponseEntity<?> deleteVacationById(Long id);


    ResponseEntity<?> updateVacation(Long id, Vacation vacation);

    ResponseEntity<?> updateVacationField(Long id, Map<String, Object> fields);
}
