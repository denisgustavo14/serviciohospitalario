package com.examen.servicioHospitalario.repository;

import com.examen.servicioHospitalario.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByDoctor_IdDoctorAndHorarioBetween(Long idDoctor, LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Cita> findByHorarioBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Cita> findByPaciente_IdPacienteAndHorarioBetween(Long idPaciente, LocalDateTime inicio, LocalDateTime fin);


    boolean existsByConsultorio_IdConsultorioAndHorario(Long idConsultorio, LocalDateTime horario);

    boolean existsByDoctor_IdDoctorAndHorario(Long idDoctor, LocalDateTime horario);

    long countByDoctor_IdDoctorAndHorarioBetween(Long idDoctor, LocalDateTime fechaInicio, LocalDateTime fechaFin);
}
