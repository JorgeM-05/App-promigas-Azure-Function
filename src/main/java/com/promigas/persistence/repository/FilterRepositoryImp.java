package com.promigas.persistence.repository;

import com.promigas.domain.dto.request.CountryDto;
import com.promigas.domain.dto.request.FilterDtoRequest;
import com.promigas.domain.dto.request.SectorDto;
import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.OpportunitiesEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilterRepositoryImp extends AbstractRepositoryDatabase implements FilterRepository{
    private static String countryQuery = "";
    private static String sectorQuery = "";
    private static String capexQuery = "";
    private static String greenfieldQuery = "";
    private static String mYaQuery = "";


    @Override
    public List<OpportunitiesEntity> findByIdCountry(FilterDtoRequest filterDtoRequest, ConnectionInfo connectionInfo) {

        getConnectionSQLServer(connectionInfo);
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<>();

        countryQuery = mapToQueryCountry(filterDtoRequest.getCountries());
        sectorQuery = mapToQuerySector(filterDtoRequest.getSectorDtos());
        capexQuery = mapToQueryCapex(filterDtoRequest.getMinCapex(),filterDtoRequest.getMaxCapex());
        greenfieldQuery = filterDtoRequest.getGreenfield();
        mYaQuery = filterDtoRequest.getMya();
        String QUERY_FILTER =
                " select o.unique_id, o.project_title \n" +
                        "\tfrom dbo.opportunities o\n" +
                        "\twhere o.greenfield like '%"+greenfieldQuery+"%' AND o.mYa like '%"+mYaQuery+"%'\n" +
                        " \tAND o.id_country in (\n" +
                        "\t\tselect c.unique_id from dbo.country c \n" +countryQuery+
                        " \t) AND  o.id_sector IN (\n" +
                        "\t\tselect s.unique_id from dbo.sector s\n" + sectorQuery+
                        " \t) AND o.unique_id in (\n" +
                        " \t\tselect cx.id_opportunity from cf_capex cx\n" +capexQuery+
                        "\t\tAND  YEAR(cx.year) in (\n" +
                        " \t\t\tselect MAX(YEAR(c.year)) from cf_capex c group by c.id_opportunity\n" +
                        "\t\t)\n" +
                        "\t)";

        try {
            PreparedStatement oppQuery = connection.prepareStatement(QUERY_FILTER);
            ResultSet opprs = oppQuery.executeQuery();

            while (opprs.next()) {
                OpportunitiesEntity opp = new OpportunitiesEntity();

                opp.setUnique_id(Integer.parseInt(opprs.getString("unique_id")));
                opp.setProjecTitle(opprs.getString("project_title"));
                opportunitiesEntities.add(opp);
            }
            return opportunitiesEntities;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            closeConnection();
        }
    }

    public String mapToQueryCountry(List<CountryDto> countries){
        String query = "WHERE";
        if(countries.size()>0) {
            boolean ctn=true;
            for (CountryDto fil : countries) {
                if (fil != null) {
                    if(ctn){
                        query += " c.unique_id = " + fil.getUnique_id();
                        ctn = false;
                    }else {
                        query += "OR c.unique_id = " + fil.getUnique_id();
                    }
                }
            }
        }else {
            query = "";
        }
        return query;
    }
    public String mapToQuerySector(List<SectorDto> sectorDtos){
        String query = "WHERE";
        if(sectorDtos.size()>0) {
            boolean ctn=true;
            for (SectorDto fil : sectorDtos) {
                if (fil != null) {
                    if(ctn) {
                        query += " s.unique_id = " + fil.getUnique_id();
                        ctn=false;
                    }else {
                        query += "OR s.unique_id = " + fil.getUnique_id();
                    }
                }
            }
        }else {
            query = "";
        }
        return query;
    }

    public String mapToQueryCapex(int min, int max){
        String query = "WHERE";
        if(min >= 0 && max>0) {
            if(max>min) {
                query += " cx.value_capex_usd > " + min + " and cx.value_capex_usd < " + max;
            }else {
                query += " cx.value_capex_usd > 0";
            }
        }else if(min >= 0 && max<0) {
            query += " cx.value_capex_usd > "+min;
        }
        else {
            query += " cx.value_capex_usd > 0";
        }
        return query;
    }

}

