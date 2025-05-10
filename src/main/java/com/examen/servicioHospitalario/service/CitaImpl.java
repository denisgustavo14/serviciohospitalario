package com.examen.servicioHospitalario.service;

import com.examen.servicioHospitalario.model.Cita;
import com.examen.servicioHospitalario.repository.CitaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CitaImpl implements ICita {

    private final CitaRepository citaRepository;

    @Override
    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Optional<Cita> buscarPorId(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public boolean existeCitaConsultorioHorario(Long consultorioId, LocalDateTime horario) {
        return citaRepository.existsByConsultorioIdAndHorario(consultorioId, horario);
    }

    @Override
    public boolean existeCitaDoctorHorario(Long doctorId, LocalDateTime horario) {
        return citaRepository.existsByDoctorIdAndHorario(doctorId, horario);
    }

    @Override
    public long contarCitasDoctorEnDia(Long doctorId, LocalDate fecha) {
        return citaRepository.countByDoctorAndHorarioBetween(doctorId, fecha.atStartOfDay(), fecha.atTime(23, 59));
    }

    @Override
    public List<Cita> citasPacienteEntre(Long pacienteId, LocalDateTime desde, LocalDateTime hasta) {
        return citaRepository.findByPacienteAndHorarioBetween(pacienteId, desde, hasta);
    }

    @Override
    public List<Cita> citasDoctorEnDia(Long doctorId, LocalDate fecha) {
        return citaRepository.findByDoctorIdAndHorarioBetween(doctorId, fecha.atStartOfDay(), fecha.atTime(23, 59));
    }

    @Override
    public List<Cita> citasPorFecha(LocalDate fecha) {
        return citaRepository.findByHorarioBetween(fecha.atStartOfDay(), fecha.atTime(23, 59));
    }
}
