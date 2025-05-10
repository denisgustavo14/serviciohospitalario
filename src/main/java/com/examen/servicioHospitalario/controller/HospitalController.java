package com.examen.servicioHospitalario.controller;

import com.examen.servicioHospitalario.dto.CitaRequest;
import com.examen.servicioHospitalario.dto.CitaResponse;
import com.examen.servicioHospitalario.service.IHospital;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/hospital")
public class HospitalController {

    private final IHospital iHospital;

    @PostMapping("/crearCita")
    public CitaResponse crearCita(@RequestBody CitaRequest citaRequest) {
        return iHospital.crearCita(citaRequest);
    }
}
