package com.arunava.service;

import com.arunava.exception.UserNotFoundException;
import com.arunava.model.Vacation;
import com.arunava.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepo;

    @Override
    public ResponseEntity<?> saveVacation(Vacation vacation) {
        return new ResponseEntity<>(vacationRepo.save(vacation), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getVacation() {
        return new ResponseEntity<>(vacationRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getVacationById(Long id) {
        Vacation vacation = vacationRepo.findById(id).get();

        return new ResponseEntity<>(vacation, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteVacationById(Long id) {
        Vacation vacation = vacationRepo.findById(id).get();
        vacationRepo.deleteById(id);

        return new ResponseEntity<>("delete Successfully", HttpStatus.OK);
    }
}
