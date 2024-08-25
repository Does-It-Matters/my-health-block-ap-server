package com.example.myhealthblock.patient.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer> {
}
