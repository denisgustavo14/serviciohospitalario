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
    public boolean existeCitaConsultorioHorario(Long consultorioId, LocalDateTime horario) {
        return citaRepository.existsByConsultorio_IdConsultorioAndHorario(consultorioId, horario);
    }

    @Override
    public boolean existeCitaDoctorHorario(Long idDoctor, LocalDateTime horario) {
        return citaRepository.existsByDoctor_IdDoctorAndHorario(idDoctor, horario);
    }

    @Override
    public long contarCitasDoctorEnDia(Long idDoctor, LocalDate fecha) {
        return citaRepository.countByDoctor_IdDoctorAndHorarioBetween(idDoctor, fecha.atStartOfDay(), fecha.atTime(23, 59));
    }

    @Override
    public List<Cita> citasPacienteEntre(Long pacienteId, LocalDateTime desde, LocalDateTime hasta) {
        return citaRepository.findByPaciente_IdPacienteAndHorarioBetween(pacienteId, desde, hasta);
    }

    @Override
    public List<Cita> citasDoctorEnDia(Long idDoctor, LocalDate fecha) {
        return citaRepository.findByDoctor_IdDoctorAndHorarioBetween(idDoctor, fecha.atStartOfDay(), fecha.atTime(23, 59));
    }

    @Override
    public List<Cita> citasPorFecha(LocalDate fecha) {
        return citaRepository.findByHorarioBetween(fecha.atStartOfDay(), fecha.atTime(23, 59));
    }
}
