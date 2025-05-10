package com.examen.servicioHospitalario.repository;

import com.examen.servicioHospitalario.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByDoctorIdAndHorarioBetween(Long idDoctor, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Cita> findByHorarioBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Cita> findByPacienteAndHorarioBetween(Long idPaciente, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    boolean existsByConsultorioIdAndHorario(Long idConsultorio, LocalDateTime horario);

    boolean existsByDoctorIdAndHorario(Long idDoctor, LocalDateTime horario);

    long countByDoctorAndHorarioBetween(Long idDoctor, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
