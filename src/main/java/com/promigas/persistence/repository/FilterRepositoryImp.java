package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.OpportunitiesEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FilterRepositoryImp extends AbstractRepositoryDatabase implements FilterRepository{
    private static final String QUERY_FILTER = "select o.unique_id, o.project_title \n" +
            "\tfrom dbo.opportunities o\n" +
            "\twhere o.greenfield like '%%' AND o.mYa like '%%'\n" +
            "\tAND o.id_country in (\n" +
            "\t\tselect c.unique_id from dbo.country c \n" +
            "\t\twhere c.unique_id = 1 OR c.unique_id=2\n" +
            "\t)\n" +
            "\tAND  o.id_sector IN (\n" +
            "\t\tselect s.unique_id from dbo.sector s\n" +
            "\t\t--where s.unique_id = 1\n" +
            "\t)\n" +
            "\tAND o.unique_id in (\n" +
            "\t\tselect cx.id_opportunity from cf_capex cx\n" +
            "\t\twhere cx.value_capex_usd > 0  and cx.value_capex_usd < 30\n" +
            "\t\tAND  YEAR(cx.year) in (\n" +
            "\t\t\tselect MAX(YEAR(c.year)) from cf_capex c group by c.id_opportunity\n" +
            "\t\t)\n" +
            "\t)";

    @Override
    public List<OpportunitiesEntity> findByIdCountry(String country, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<OpportunitiesEntity> opportunitiesEntities = new ArrayList<>();

        try {
            PreparedStatement oppQuery = connection.prepareStatement(QUERY_FILTER);
            oppQuery.setString(1, country);
            ResultSet opprs = oppQuery.executeQuery();

            while (opprs.next()) {
                OpportunitiesEntity opp = new OpportunitiesEntity();

                opp.setUnique_id(Integer.parseInt(opprs.getString("unique_id")));
                opp.setProjecTitle(opprs.getString("project_title"));
                opportunitiesEntities.add(opp);

            }
            System.out.println("filter :: "+opportunitiesEntities);
            return opportunitiesEntities;
        }catch(Exception ex){
//            System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        }finally{
            closeConnection();
        }
    }
}

