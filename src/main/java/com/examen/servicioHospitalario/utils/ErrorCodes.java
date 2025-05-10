package com.examen.servicioHospitalario.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {

    NOT_FOUND("HOSP-404", "Informacion no encontrada.", "La informacion solicitada no fue encontrada."),

    BAD_GATEWAY("HOSP-502", "Error de conexion", "No es posible establecer una conexión con el servidor."),

    BAD_REQUEST("HOSP-400", "Solicitud incorrecta.", "La solicitud tiene un formato incorrecto."),

    INTERNAL_SERV_ERR("HOSP-500", "Error interno de servidor.", "Ocurrió un error interno, por favor intente más tarde."),

    UNPROCESSABLE_ENTITY("HOSP-422", "Entidad Inprocesable.", "La solicitud no pudo ser procesada"),

    CONFLICT("HOSP-409", "Conflicto.", "Un conflicto fue encontrado en la solicitud.");

    private final String code;

    private final String shortMessage;

    private final String message;
}
