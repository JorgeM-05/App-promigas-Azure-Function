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
            ResultSet rs11 = Query.executeQuery();
            while (rs11.next()) {
                DistributionEntity dis = new DistributionEntity();
                dis.setUnique_id(rs11.getInt("unique_id"));
                dis.setVolumeDistribution(rs11.getString("volume_distribution"));
                dis.setDistriPeriod(rs11.getString("distr_connec_period"));
                dis.setDistributionKms(rs11.getString("distr_kms_red"));
                dis.setDistributionUsers(rs11.getString("distr_user_accumulated"));
                dis.setDistributionPenetration(rs11.getString("distr_penetration"));
                distributionEntities.add(dis);
            }
            return distributionEntities;
        } catch (Exception ex) {
//           System.out.println(ex.getMessage(),ex);
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
            EnergySolutionEntity ener = new EnergySolutionEntity();
            ener.setUnique_id(rs10.getInt("unique_id"));
            ener.setSolenerg_power_unit(rs10.getString("solenerg_power_unit "));
            ener.setSolenerg_power_figure(rs10.getString("solenerg_power_figure"));
            ener.setSolenerg_gener_figure(rs10.getString("solenerg_gener_figure"));
            ener.setSolenerg_gener_unit(rs10.getString("solenerg_gener_unit"));
            ener.setSolenerg_degradation_average(rs10.getString("solenerg_degradation_average"));
            ener.setSolenerg_hour_sun(rs10.getString("solenerg_hour_sun"));
            energySolutionEntities.add(ener);
        }
        return energySolutionEntities;
    } catch (Exception ex) {
 //       System.out.println(ex.getMessage(),ex);
        throw new RuntimeException(ex);
    } finally {
        closeConnection();
    }
}
@Override
    public List<TransportEntity> findByTransport(int id_opportunity, ConnectionInfo connectionInfo) {
    getConnectionSQLServer(connectionInfo);
    List<TransportEntity> transportEntities = new ArrayList<TransportEntity>();

    try {
        PreparedStatement Query = connection.prepareStatement(QUERY_TRANSPORT);
        Query.setInt(1, id_opportunity);
        ResultSet rs12 = Query.executeQuery();
        while (rs12.next()) {
            TransportEntity trans = new TransportEntity();
            trans.setUnique_id(rs12.getInt("unique_id"));
            trans.setTransportCapacityMax(rs12.getString("transp_capacity_max  "));
            trans.setTransportCapacityHired(rs12.getString("trans_capacity_hired"));
            trans.setTransportVolumen(rs12.getString("trans_vol_trans "));
            trans.setTransportLength(rs12.getString("trans_length_gasod "));
            transportEntities.add(trans);
        }
        return transportEntities;
    } catch (Exception ex) {
 //       System.out.println(ex.getMessage(), ex);
        throw new RuntimeException(ex);
    } finally {
        closeConnection();
    }
}