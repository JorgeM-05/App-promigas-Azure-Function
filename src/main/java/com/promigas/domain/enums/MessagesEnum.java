package com.promigas.domain.enums;

public enum MessagesEnum {
    ERROR_DB(5002,"Error al ejecutar sentencia de base de datos: ", 500),
    ERROR_DB_CON(5003,"Error al al obtener conexion a base de datos: ",500),

    BE_FIELDS_INPUT_QUERY_CLIENT (4002, "Debe ingresar alguno de los siguientes campos [typedoc and identification] [product] [account]",400),

    BE_AUTH_INCORRECT (4003, "Usuario o Clave incorrecto",400),
    BE_FIELDS_MANDATORY(4004, "Campos obligatorios no enviados :", 400)
    ;
    MessagesEnum( long code, String message,int httpCode){
        this.codeMessage = code;
        this.message = message;
        this.httpCode = httpCode;
    }
    private String message;
    private  long codeMessage;
    private int httpCode;

    public String getMessage() {
        return message;
    }

    public long getCodeMessage() {
        return codeMessage;
    }

    public int getHttpCode() {
        return httpCode;
    }
}
