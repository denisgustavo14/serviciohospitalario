package com.examen.servicioHospitalario.service;

import com.examen.servicioHospitalario.dto.CitaRequest;
import com.examen.servicioHospitalario.dto.CitaResponse;

import java.time.LocalDate;
import java.util.List;

public interface IHospital {

    CitaResponse crearCita(final CitaRequest citaRequest);

    List<CitaResponse> getCitasPorDocYFech(final Long id, final LocalDate fecha);
}
