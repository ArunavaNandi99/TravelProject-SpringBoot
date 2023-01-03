package com.arunava.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arunava.model.Vacation;
import com.arunava.service.VacationService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class VacationController {


    @Autowired
    private VacationService vacationService;

    @PostMapping("/vacation")
    public ResponseEntity<?> saveVacation(@Valid @RequestBody Vacation vacation){
        return  vacationService.saveVacation(vacation);
    }

    @GetMapping("/vacations")
    public ResponseEntity<?> getVacations(){
        return vacationService.getVacation();
    }

    @GetMapping("/vacation/{id}")
    public ResponseEntity<?> getVacationById(@PathVariable Long id){
        return vacationService.getVacationById(id);

    }
    @PutMapping("vacation/{id}")
    public ResponseEntity<?> updateVacation(@Valid @PathVariable Long id, @RequestBody Vacation vacation){
        return vacationService.updateVacation(id, vacation);
    }

    @PatchMapping("vacation/{id}")
    public ResponseEntity<?> updateVacationField(@Valid @PathVariable Long id,@RequestBody Map<String,Object> fields){
        return vacationService.updateVacationField(id,fields);
    }

    @DeleteMapping("/vacation/{id}")
    public ResponseEntity<?> deleteVacationById(@PathVariable Long id){
        return  vacationService.deleteVacationById(id);

    }
}
