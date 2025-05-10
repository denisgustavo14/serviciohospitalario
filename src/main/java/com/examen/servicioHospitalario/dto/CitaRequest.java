package com.examen.servicioHospitalario.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class CitaRequest {

    @NotNull(message = "el campo es requerido")
    @Positive(message = "el campo debe ser un positivo")
    private Long idDoctor;

    @NotNull(message = "el campo es requerido")
    @Positive(message = "el campo debe ser un positivo")
    private Long idConsultorio;

    @NotNull(message = "el campo es requerido")
    @Positive(message = "el campo debe ser un positivo")
    private Long idPaciente;

    @NotNull(message = "el campo es requerido")
    private LocalDateTime horario;
}
