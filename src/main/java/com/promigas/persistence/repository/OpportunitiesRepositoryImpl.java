package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.CountryEntity;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.entity.SectorEntity;
import com.promigas.persistence.entity.TypeContractEntity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OpportunitiesRepositoryImpl extends AbstractRepositoryDatabase{
    private static final String QUERY_OPPORTUNITIES = "select * from dbo.opportunities op INNER JOIN dbo.country c \n" +
                                                    "\t\t On c.unique_id = op.id_country \n" +
                                                    "\t INNER JOIN dbo.type_contract t \n" +
                                                    "\t\t On t.unique_id = op.type_contract \n" +
                                                    "\t INNER JOIN dbo.sector s \n" +
                                                    "\t\t On s.unique_id = op.id_sector;";

    public List<OpportunitiesEntity> findOpportunities(ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<OpportunitiesEntity> opportunitiesEntity = new ArrayList<OpportunitiesEntity>();

        try{
            PreparedStatement oppQuery = connection.prepareStatement(QUERY_OPPORTUNITIES);
            ResultSet opprs = oppQuery.executeQuery();

            while(opprs.next()){
                OpportunitiesEntity opp = new OpportunitiesEntity();
                SectorEntity sectorEntity = new SectorEntity();
                TypeContractEntity typeContractEntity = new TypeContractEntity();
                CountryEntity countryEntity = new CountryEntity();

                countryEntity.setUnique_id(Integer.parseInt(opprs.getString(20)));
                countryEntity.setNameContry(opprs.getString("name_contry"));
                sectorEntity.setTypeSector(opprs.getString("type_contract"));
                typeContractEntity.setUnique_id(Integer.parseInt(opprs.getString(24)));
                typeContractEntity.setTypeContract(opprs.getString("type_sector"));

                opp.setIdCountry(countryEntity);
                opp.setIdSector(sectorEntity);
                opp.setIdContract(typeContractEntity);

                opp.setUnique_id(Integer.parseInt(opprs.getString("unique_id")));
                opp.setGreenfield(opprs.getString("greenfield"));
                opp.setMYA(opprs.getString("mYa"));
                opp.setProjecTitle(opprs.getString("project_title"));
                opp.setDate(opprs.getString("date_update"));
                opp.setCoordinates(opprs.getString("coordinates"));
                opp.setDescrip(opprs.getString("opportunity_descrip"));
                opp.setHorizonope(opprs.getString("horizon_operation"));
                opp.setPoc(opprs.getString("POC"));
                opp.setTrmBase(opprs.getString("TRM_base_capex"));
                opp.setTrmFin(opprs.getString("TRM_fin_capex"));
                opp.setPropCapexUsd(opprs.getString("prop_capex_usd"));
                opp.setPropCapexCop(opprs.getString("prop_capex_cop"));
                opp.setFinancilAsset(opprs.getString("financial_asset"));

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
