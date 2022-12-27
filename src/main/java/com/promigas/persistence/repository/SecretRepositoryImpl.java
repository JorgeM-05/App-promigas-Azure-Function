package com.promigas.persistence.repository;

import com.google.gson.Gson;
import com.promigas.domain.dto.ConnectionInfo;

public class SecretRepositoryImpl implements SecretRepository{
    @Override
    public String querySecret(String secretName) {

        ConnectionInfo connection = new ConnectionInfo();
        if ("connectionSQL".equals(secretName)) {
            connection.setConnectionPattern("jdbc:sqlserver://{0}:{1};encrypt=true;databaseName={2};user={3};password={4};trustServerCertificate=true");
            connection.setHost("localhost");
            connection.setPort("1433");
            connection.setSchema("promigas");
            connection.setUser("sa");
            connection.setPwd("root");
            /*
            connection.setConnectionPattern("jdbc:sqlserver://{0}:{1};encrypt=true;databaseName={2};user={3};password={4}");
            connection.setHost("sql-server-001-dev.database.windows.net");
            connection.setPort("1433");
            connection.setSchema("DB_GESTOR");
            connection.setUser("gvd@sql-server-001-dev");
            connection.setPwd("FGA0vlGaBtfl3UtFfPnM");
            */
        }

        return new Gson().toJson(connection);
    }
}
