package com.arunava.service;

import com.arunava.model.Vacation;
import org.springframework.http.ResponseEntity;

public interface VacationService {
    ResponseEntity<?> saveVacation(Vacation vacation);
}
