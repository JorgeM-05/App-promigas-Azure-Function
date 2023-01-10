package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.SectorEntity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SectorRepositoryImp extends AbstractRepositoryDatabase{

    private static final String QUERY_SECTORS = "select * from dbo.sector";

    public List<SectorEntity> findSector(ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<SectorEntity> sectorsEntity = new ArrayList<SectorEntity>();
        System.out.println("1.1");

        try {
            PreparedStatement oppQuery = connection.prepareStatement(QUERY_SECTORS);
            ResultSet sect = oppQuery.executeQuery();

        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }
        return null;
    }

}
