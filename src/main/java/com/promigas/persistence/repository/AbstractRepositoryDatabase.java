package com.promigas.persistence.repository;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.domain.enums.LogEnum;
import com.promigas.domain.enums.MessagesEnum;
import com.promigas.domain.exception.PromigasException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;


public class AbstractRepositoryDatabase {
    protected Connection connection;

    protected void getConnectionSQLServer(ConnectionInfo connectionInfo) {
        System.out.println(LogEnum.MESSAGES_CONEXION.getMessage());
        String connectionString ="";// =  MessageFormat.format(connectionInfo.getConnectionPattern(), connectionInfo.getHost(),connectionInfo.getPort(),connectionInfo.getSchema(),connectionInfo.getUser(), connectionInfo.getPwd() );

        //pasandole los datos seteados
//        String connectionString =  MessageFormat.format(connectionInfo.getConnectionPattern(), connectionInfo.getHost(),connectionInfo.getPort(),connectionInfo.getSchema(),connectionInfo.getUser(), connectionInfo.getPwd() );

        JSONParser jsonparser = new JSONParser();
        FileReader localSettingsReader = null;
        try {
            //de forma local
            localSettingsReader = new FileReader(".\\local.settings.json");
            Object obj = jsonparser.parse(localSettingsReader);
            JSONObject localsettingsobject = (JSONObject)obj;
            connectionString = (String) localsettingsobject.get("ConnectionSQLServer");

            // servidor
//            connectionString = System.getenv("ConnectionSQLServer");

            connection = DriverManager.getConnection(connectionString);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (Exception ex){
            throw new PromigasException(MessagesEnum.ERROR_DB_CON.getCodeMessage(),MessagesEnum.ERROR_DB_CON.getMessage(),MessagesEnum.ERROR_DB_CON.getHttpCode());
        }
    }

    protected void closeConnection(){

        try {
            connection.close();
        }catch (Exception ex){
            System.out.println("Error al cerrar conexion:"+ ex.getMessage());
        }
    }
}
