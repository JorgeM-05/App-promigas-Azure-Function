package com.promigas.persistence.repository;

import com.google.gson.Gson;
import com.promigas.domain.dto.response.ConnectionInfo;

public class SecretRepositoryImpl implements SecretRepository{
    @Override
    public String querySecret(String secretName) {

        ConnectionInfo connection = new ConnectionInfo();
        if ("connectionSQL".equals(secretName)) {
            connection.setConnectionPattern("jdbc:sqlserver://{0}:{1};encrypt=true;databaseName={2};user={3};password={4}");
            connection.setHost("sql-server-001-dev.database.windows.net");
            connection.setPort("1433");
            connection.setSchema("sql-dpi-dev");
            connection.setUser("usrdpi");
            connection.setPwd("7IH5HYyYUOpFgUqIc789!");

        }

        return new Gson().toJson(connection);
    }
}
