package com.examen.servicioHospitalario.service;

import com.examen.servicioHospitalario.model.Cita;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ICita {

    Cita guardar(Cita cita);

    Optional<Cita> buscarPorId(Long id);

    boolean existeCitaConsultorioHorario(Long consultorioId, LocalDateTime horario);

    boolean existeCitaDoctorHorario(Long doctorId, LocalDateTime horario);

    long contarCitasDoctorEnDia(Long doctorId, LocalDate fecha);

    List<Cita> citasPacienteEntre(Long pacienteId, LocalDateTime desde, LocalDateTime hasta);

    List<Cita> citasDoctorEnDia(Long doctorId, LocalDate fecha);

    List<Cita> citasPorFecha(LocalDate fecha);
}
