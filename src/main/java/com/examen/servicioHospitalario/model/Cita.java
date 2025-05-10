package com.examen.servicioHospitalario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCita;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Consultorio consultorio;

    private LocalDateTime horario;
}
