package com.examen.servicioHospitalario.dto;

import com.examen.servicioHospitalario.model.Consultorio;
import com.examen.servicioHospitalario.model.Doctor;
import com.examen.servicioHospitalario.model.Paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaResponse {

    private Long idCita;

    private Doctor doctor;

    private Paciente paciente;

    private Consultorio consultorio;

    private LocalDateTime horaConsulta;
}
