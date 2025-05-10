package com.examen.servicioHospitalario.controller;

import com.examen.servicioHospitalario.dto.CitaRequest;
import com.examen.servicioHospitalario.dto.CitaResponse;
import com.examen.servicioHospitalario.service.IHospital;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hospital")
public class HospitalController {

    private final IHospital iHospital;

    @PostMapping("/crearCita")
    public CitaResponse crearCita(final @Valid @RequestBody CitaRequest citaRequest) {
        return iHospital.crearCita(citaRequest);
    }

    @GetMapping("/citasPorDocYFecha/{id}/fecha/{fecha}")
    public List<CitaResponse> getCitasPorDc(final @PathVariable Long id, final @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return iHospital.getCitasPorDocYFech(id, fecha);
    }
}
