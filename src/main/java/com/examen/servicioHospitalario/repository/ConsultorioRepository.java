package com.examen.servicioHospitalario.repository;

import com.examen.servicioHospitalario.model.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
    Optional<Consultorio> findById(Long idConsultorio);
}
