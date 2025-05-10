package com.examen.servicioHospitalario.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorHospital {

    private String codigoError;

    private String mensajeCorto;

    private String mensaje;
}
