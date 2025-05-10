package com.examen.servicioHospitalario.service;

import com.examen.servicioHospitalario.dto.CitaRequest;
import com.examen.servicioHospitalario.dto.CitaResponse;

public interface IHospital {

    CitaResponse crearCita(CitaRequest citaRequest);
}
