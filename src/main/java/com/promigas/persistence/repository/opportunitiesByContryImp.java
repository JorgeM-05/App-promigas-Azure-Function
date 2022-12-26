package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.CountryEntity;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.entity.SectorEntity;
import com.promigas.persistence.entity.TypeContractEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class opportunitiesByContryImp extends AbstractRepositoryDatabase implements OpportunitiesRepository{

    private static final String QUERY_OPPORTUNITIES = "select * from dbo.opportunities op \n" +
            "INNER Join dbo.country c On op.id_country=c.unique_id\n" +
            "INNER JOIN dbo.type_contract t On t.unique_id = op.type_contract\n" +
            "\tINNER JOIN dbo.sector s\tOn s.unique_id = op.id_sector\n" +
            "where c.name_contry = ?";
    
    @Override
    public List<OpportunitiesEntity> findByIdCountry(String country, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<>();

        try{
            PreparedStatement oppQuery = connection.prepareStatement(QUERY_OPPORTUNITIES);
            oppQuery.setString(1,country);
            ResultSet opprs = oppQuery.executeQuery();

            while(opprs.next()) {
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

                opportunitiesEntities.add(opp);
            }

            return opportunitiesEntities;
        }catch(Exception ex){
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }finally {
            closeConnection();
        }
    }


    @Override
    public OpportunitiesEntity findById(Integer id, ConnectionInfo connectionInfo) {
        return null;
    }
}
