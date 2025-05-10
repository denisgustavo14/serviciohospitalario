package com.examen.servicioHospitalario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consultorio {

    public Consultorio(Long idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultorio;

    private int numConsultorio;

    private int piso;
}
