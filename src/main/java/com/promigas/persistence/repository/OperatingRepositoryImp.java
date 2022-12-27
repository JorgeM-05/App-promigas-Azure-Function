package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;
import com.promigas.persistence.entity.FiguresFinancial.IncomeEntity;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.entity.operatingFinancial.DistributionEntity;
import com.promigas.persistence.entity.operatingFinancial.EnergySolutionEntity;
import com.promigas.persistence.entity.operatingFinancial.TransportEntity;
import io.swagger.v3.oas.annotations.Operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OperatingRepositoryImp extends AbstractRepositoryDatabase implements OperatingRepository {
    private static final String QUERY_DISTRIBUTION = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_ENERGY = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_TRANSPORT = "select * from dbo.cf_capex c where c.id_opportunity=?";


        @Override
        public List<DistributionEntity> findByDistribution(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<DistributionEntity> distributionEntities = new ArrayList<DistributionEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_DISTRIBUTION);
            Query.setInt(1, id_opportunity);
            ResultSet rs9 = Query.executeQuery();
            while (rs9.next()) {
                DistributionEntity dis = new DistributionEntity();
                dis.setUnique_id(rs9.getInt("unique_id"));
                dis.setVolumeDistribution(rs9.getString("volume_distribution"));
                dis.setDistriPeriod(rs9.getString("distr_connec_period"));
                dis.setDistributionKms(rs9.getString("distr_kms_red"));
                dis.setDistributionUsers(rs9.getString("distr_user_accumulated"));
                dis.setDistributionPenetration(rs9.getString("distr_penetration"));
                distributionEntities.add(dis);
            }
            return distributionEntities;
        } catch (Exception ex) {
           System.out.println(ex.getMessage(),ex);
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }



    }

    @Override
    public List<EnergySolutionEntity> findByEnergy(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<EnergySolutionEntity> energySolutionEntities = new ArrayList<EnergySolutionEntity>();

        try {
        PreparedStatement Query = connection.prepareStatement(QUERY_ENERGY);
        Query.setInt(1, id_opportunity);
        ResultSet rs10 = Query.executeQuery();
        while (rs10.next()) {
            DistributionEntity ener = new DistributionEntity();
            ener.setUnique_id(rs10.getInt("unique_id"));
            ener.setS(rs10.getString("volume_distribution"));
            ener.setDistriPeriod(rs10.getString("distr_connec_period"));
            ener.setDistributionKms(rs10.getString("distr_kms_red"));
            ener.setDistributionUsers(rs10.getString("distr_user_accumulated"));
            ener.setDistributionPenetration(rs10.getString("distr_penetration"));
            energySolutionEntities.add(ener);
        }
        return distributionEntities;
    } catch (Exception ex) {
        System.out.println(ex.getMessage(),ex);
        throw new RuntimeException(ex);
    } finally {
        closeConnection();
    }



}    @Override
    public List<TransportEntity> findByTransport(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }
}
