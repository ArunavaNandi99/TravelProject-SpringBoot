package com.arunava.controller;

import com.arunava.exception.UserNotFoundException;
import com.arunava.model.Vacation;
import com.arunava.repository.VacationRepository;
import com.arunava.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
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
        //Vacation saveVacation = vacationRepository.save(vacation);
        // return new ResponseEntity<>(saveVacation,HttpStatus.CREATED);
        return  vacationService.saveVacation(vacation);
    }

    @GetMapping("/vacation")
    public ResponseEntity<?>getVacations(){
        List<Vacation> vacations = vacationRepository.findAll();
        return new ResponseEntity<>(vacations, HttpStatus.OK);
    }

    @GetMapping("/vacation/{id}")
    public ResponseEntity<?> getVacationById(@PathVariable Long id){
        Vacation vacation = vacationRepository.findById(id).get();

        if(vacation == null) {
            throw new UserNotFoundException("user not found by id :"+id);
        }
        return new ResponseEntity<>(vacation,HttpStatus.OK);

    }

    @DeleteMapping("/vacation/{id}")
    public ResponseEntity<?> deleteVacationById(@PathVariable Long id){
        Vacation vacation = vacationRepository.findById(id).get();

        if(vacation == null) {
            throw new UserNotFoundException("id : "+id);
        }
        vacationRepository.deleteById(id);
        return new ResponseEntity<>("delete successfully",HttpStatus.OK);

    }


}
