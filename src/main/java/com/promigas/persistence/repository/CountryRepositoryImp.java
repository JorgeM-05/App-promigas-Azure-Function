package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.CountryEntity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CountryRepositoryImp extends AbstractRepositoryDatabase {

    private static final String QUERY_COUNTRIES = "select * from dbo.country";



    public List<CountryEntity> findCountry(ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<CountryEntity> countriesEntity = new ArrayList<CountryEntity>();
        System.out.println("1.1");

        try {
            PreparedStatement oppQuery = connection.prepareStatement(QUERY_COUNTRIES);
            ResultSet count = oppQuery.executeQuery();

        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }
        return null;
    }

}
