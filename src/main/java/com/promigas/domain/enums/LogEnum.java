package com.promigas.domain.enums;

public enum LogEnum {
    MESSAGE(""),
    MESSAGES_CONEXION("Obteniendo conexion a base de datos"),
    ERROR_CONEXION_BD("Error al obtener conexión a base de datos"),
    ;

    private LogEnum(String message){
        this.message = message;

    }

    private String message;

    public String getMessage() {
        return message;
    }
}
