package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.domain.enums.LogEnum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.MessageFormat;


public class AbstractRepositoryDatabase {
    protected Connection connection;



    protected void getConnectionSQLServer(ConnectionInfo connectionInfo) {
        System.out.println(LogEnum.MESSAGES_CONEXION.getMessage());
        String connectionString =  MessageFormat.format(connectionInfo.getConnectionPattern(), connectionInfo.getHost(),connectionInfo.getPort(),connectionInfo.getSchema(),connectionInfo.getUser(), connectionInfo.getPwd() );
        System.out.println("connection String::  "+connectionString);
        DriverManager.setLoginTimeout(connectionInfo.getConnectionTimeout());
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver funciona correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try{
            connection = DriverManager.getConnection(connectionString);
            System.out.println("-->"+connection);

        }catch (Exception e){
            System.out.println(e);
        }

//        try {
//            System.out.println("conectando ...");
//        }catch (Exception ex){
////            System.out.println(LogEnum.ERROR_CONEXION_BD.getMessage()+ex.getMessage(),ex);
//            throw new PromigasException(MessagesEnum.ERROR_DB_CON.getCodeMessage(),MessagesEnum.ERROR_DB_CON.getMessage(),MessagesEnum.ERROR_DB_CON.getHttpCode());
//        }
    }

    protected void closeConnection(){

        try {
            connection.close();
        }catch (Exception ex){
            System.out.println("Error al cerrar conexion:"+ ex.getMessage());
        }
    }
}
