package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.OpportunitiesEntity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OpportunitiesRepositoryImpl extends AbstractRepositoryDatabase{
    private static final String QUERY_OPPORTUNITIES = "SELECT * FROM dbo.opportunities";

    public List<OpportunitiesEntity> findOpportunities(ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<OpportunitiesEntity> opportunitiesEntity = new ArrayList<OpportunitiesEntity>();

        try{
            PreparedStatement ps = connection.prepareStatement(QUERY_OPPORTUNITIES);

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("filas:: "+rs.getMetaData());
            int ctn=0,size =0;
            OpportunitiesEntity opp = new OpportunitiesEntity();
            while(rs.next()){

                for(int i=1;i<rsmd.getColumnCount();i++){
                    opp.setGreenfield(rs.getString("greenfield"));
                    opp.setMYA(rs.getString("mYa"));
                    opp.setProjecTitle(rs.getString("project_title"));
                    opp.setDate(rs.getString("date_update"));
                    opp.setCoordinates(rs.getString("coordinates"));
                    opp.setDescrip(rs.getString("opportunity_descrip"));
                    opp.setHorizonope(rs.getString("horizon_operation"));
                    opp.setPoc(rs.getString("POC"));
                    opp.setTrmBase(rs.getString("TRM_base_capex"));
                    opp.setTrmFin(rs.getString("TRM_fin_capex"));
                    opp.setPropCapexUsd(rs.getString("prop_capex_usd"));
                    opp.setPropCapexCop(rs.getString("prop_capex_cop"));
                    opp.setFinancilAsset(rs.getString("financial_asset"));
                }
                opportunitiesEntity.add(opp);
            }
            return opportunitiesEntity;
        }catch(Exception ex){
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }

    }
}
