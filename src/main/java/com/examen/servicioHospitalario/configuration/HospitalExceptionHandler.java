package com.examen.servicioHospitalario.configuration;

import com.examen.servicioHospitalario.exception.HospitalException;
import com.examen.servicioHospitalario.dto.ErrorHospital;
import com.examen.servicioHospitalario.utils.ErrorCodes;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorHospital> handleException(Exception exception) {
        ErrorHospital error = new ErrorHospital();
        error.setCodigoError(ErrorCodes.INTERNAL_SERV_ERR.getCode());
        error.setMensajeCorto(ErrorCodes.INTERNAL_SERV_ERR.getMessage());
        error.setMensaje("Error interno del servidor: " + exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
