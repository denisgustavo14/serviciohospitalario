package com.examen.servicioHospitalario.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HospitalException extends RuntimeException {

    private final HttpStatus httpStatus;

    private final String codigoError;

    private final String mensajeCorto;

    public HospitalException(final HttpStatus httpStatus, final String codigoError, final String mensajeCorto, final String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.codigoError = codigoError;
        this.mensajeCorto = mensajeCorto;
    }
}
