package com.examen.servicioHospitalario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CitaRequest {

    private Long idDoctor;

    private Long idConsultorio;

    private Long idPaciente;

    private LocalDateTime horario;
}
