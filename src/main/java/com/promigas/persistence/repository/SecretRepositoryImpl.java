package com.promigas.persistence.repository;

import com.google.gson.Gson;
import com.promigas.domain.dto.response.ConnectionInfo;

public class SecretRepositoryImpl implements SecretRepository{
    @Override
    public String querySecret(String secretName) {

        ConnectionInfo connection = new ConnectionInfo();
        if ("connectionSQL".equals(secretName)) {
            connection.setConnectionPattern("jdbc:sqlserver://{0}:{1};encrypt=true;databaseName={2};user={3};password={4}");
            connection.setHost("bdpromigas.database.windows.net");
            connection.setPort("1433");
            connection.setSchema("promigasdpi");
            connection.setUser("yadi");
            connection.setPwd("@pruebapdi93");

        }

        return new Gson().toJson(connection);
    }
}
