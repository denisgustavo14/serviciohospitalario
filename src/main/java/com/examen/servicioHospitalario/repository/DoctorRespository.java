package com.examen.servicioHospitalario.repository;

import com.examen.servicioHospitalario.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRespository extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findById(Long idDoctor);
}
