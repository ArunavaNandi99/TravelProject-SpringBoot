package com.arunava.controller;


import com.arunava.model.Vacation;
import com.arunava.repository.VacationRepository;
import com.arunava.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class VacationController {

    @Autowired
    private VacationRepository vacationRepository;

    @Autowired
    private VacationService vacationService;

    @PostMapping("/vacation")
    public ResponseEntity<?> saveVacation(@Valid @RequestBody Vacation vacation){
        return  vacationService.saveVacation(vacation);
    }

    @GetMapping("/vacation")
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
