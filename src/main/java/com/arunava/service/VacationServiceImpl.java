package com.arunava.service;

import com.arunava.exception.ResourceNotFoundException;
import com.arunava.model.Vacation;
import com.arunava.repository.VacationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

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
        Vacation vacation = vacationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("vacation not exists with id : " + id));

        return new ResponseEntity<>(vacation, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteVacationById(Long id) {
        Vacation vacation = vacationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("vacation not exists with id : " + id));
        if (vacation != null){
            vacationRepo.deleteById(id);
        }
        return new ResponseEntity<>("delete Successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateVacation(Long id, Vacation vacation) {
        Vacation existsVacation = vacationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation not exists with id: " + id));

        existsVacation.setHotelName(vacation.getHotelName());
        existsVacation.setDescription(vacation.getDescription());
        existsVacation.setType(vacation.getType());
        existsVacation.setCity(vacation.getCity());
        existsVacation.setPrice(vacation.getPrice());
        existsVacation.setValidTill(vacation.getValidTill());
        existsVacation.setSoldOut(vacation.isSoldOut());
        existsVacation.setImage(vacation.getImage());

        return new ResponseEntity<>(vacationRepo.save(existsVacation), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateVacationField(Long id, Map<String, Object> fields) {
        Vacation existingVacation = vacationRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Vacation not exists with id: " + id));

        //if (existingVacation != null) {
        fields.forEach((key, value) -> {
            //get the fields to setThe Fields dynamically
            Field field = ReflectionUtils.findField(Vacation.class, key);
            assert field != null;
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingVacation, value);
        });
        return new ResponseEntity<>(vacationRepo.save(existingVacation), HttpStatus.CREATED);
    }

}
