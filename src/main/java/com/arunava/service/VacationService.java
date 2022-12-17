package com.arunava.service;

import com.arunava.model.Vacation;
import org.springframework.http.ResponseEntity;

public interface VacationService {
    ResponseEntity<?> saveVacation(Vacation vacation);

    ResponseEntity<?> getVacation();

    ResponseEntity<?> getVacationById(Long id);

    ResponseEntity<?> deleteVacationById(Long id);
}
