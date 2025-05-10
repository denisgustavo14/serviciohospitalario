package com.examen.servicioHospitalario.configuration;

import com.examen.servicioHospitalario.exception.HospitalException;
import com.examen.servicioHospitalario.dto.ErrorHospital;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HospitalExceptionHandler {

    @ExceptionHandler(HospitalException.class)
    public ResponseEntity<ErrorHospital> handleHospitalException(HospitalException hospitalException) {
        ErrorHospital errorHospital = new ErrorHospital(
                hospitalException.getCodigoError(),
                hospitalException.getMensajeCorto(),
                hospitalException.getMessage()
        );
        return ResponseEntity.status(hospitalException.getHttpStatus()).body(errorHospital);
    }


}
