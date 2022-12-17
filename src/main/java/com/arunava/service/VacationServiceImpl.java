package com.arunava.service;

import com.arunava.model.Vacation;
import com.arunava.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VacationServiceImpl  implements  VacationService{

    @Autowired
    private VacationRepository vacationRepo;
    @Override
    public ResponseEntity<?> saveVacation(Vacation vacation) {
        return new  ResponseEntity<> (vacationRepo.save(vacation), HttpStatus.CREATED);
    }
}
