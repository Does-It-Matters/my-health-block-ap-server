package com.example.myhealthblock.doctor.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    DoctorEntity findByUserId(String userId);
}
