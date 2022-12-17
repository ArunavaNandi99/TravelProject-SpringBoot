package com.arunava.controller;

import com.arunava.exception.UserNotFoundException;
import com.arunava.model.Vacation;
import com.arunava.repository.VacationRepository;
import com.arunava.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VacationController {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private VacationService vacationService;

    @PostMapping("/vacation")
    public ResponseEntity<?> saveVacation(@RequestBody Vacation vacation){
        return  vacationService.saveVacation(vacation);
    }

    @GetMapping("/vacation")
    public ResponseEntity<?> getVacations(){
        return vacationService.getVacation();
    }

    @GetMapping("/vacation/{id}")
    public ResponseEntity<?> getVacationById(@PathVariable Long id){
        return  vacationService.getVacationById(id);

    }

    @DeleteMapping("/vacation/{id}")
    public ResponseEntity<?> deleteVacationById(@PathVariable Long id){
//        Vacation vacation = vacationRepository.findById(id).get();
//
//        if(vacation == null) {
//            throw new UserNotFoundException("id : "+id);
//        }
//        vacationRepository.deleteById(id);
//        return new ResponseEntity<>("delete successfully",HttpStatus.OK);

        return  vacationService.deleteVacationById(id);

    }
}
