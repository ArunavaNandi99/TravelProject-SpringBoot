package com.arunava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arunava.model.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
