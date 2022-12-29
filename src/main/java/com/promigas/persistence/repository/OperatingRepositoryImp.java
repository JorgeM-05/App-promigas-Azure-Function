package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.operatingFinancial.DistributionEntity;
import com.promigas.persistence.entity.operatingFinancial.EnergySolutionEntity;
import com.promigas.persistence.entity.operatingFinancial.TransportEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OperatingRepositoryImp extends AbstractRepositoryDatabase implements OperatingRepository {
    private static final String QUERY_DISTRIBUTION = "select * from dbo.co_distribution c where c.id_opportunity=?";
    private static final String QUERY_ENERGY = "select * from dbo.co_energy_solutions c where c.id_opportunity=?";
    private static final String QUERY_TRANSPORT = "select * from dbo.co_transport c where c.id_opportunity=?";


    @Override
    public List<DistributionEntity> findByDistribution(int id_opportunity, ConnectionInfo connectionInfo) {
        getConnectionSQLServer(connectionInfo);
        List<DistributionEntity> distributionEntities = new ArrayList<DistributionEntity>();

        try {
            PreparedStatement Query = connection.prepareStatement(QUERY_DISTRIBUTION);
            Query.setInt(1, id_opportunity);
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                DistributionEntity dis = new DistributionEntity();
                dis.setUnique_id(rs.getInt("unique_id"));
                dis.setVolumeDistribution(rs.getString("volume_distribution"));
                dis.setDistriPeriod(rs.getString("distr_connec_period"));
                dis.setDistributionKms(rs.getString("distr_kms_red"));
                dis.setDistributionUsers(rs.getString("distr_user_accumulated"));
                dis.setDistributionPenetration(rs.getString("distr_penetration"));
                distributionEntities.add(dis);
            }
            return distributionEntities;
        } catch (Exception ex) {
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                EnergySolutionEntity ener = new EnergySolutionEntity();
                ener.setUnique_id(rs.getInt("unique_id"));
                ener.setSolEnergyPowerUnit(rs.getString("solenerg_power_unit"));
                ener.setSolEnergyPowerFigure(rs.getString("solenerg_power_figure"));
                ener.setSolGenerUnit(rs.getString("solenerg_gener_figure"));
                ener.setSolGenerFigure(rs.getString("solenerg_gener_unit"));
                ener.setSolDegradation(rs.getString("solenerg_degradation_average"));
                ener.setSolEnergyHourSun(rs.getString("solenerg_hour_sun"));

                energySolutionEntities.add(ener);
            }
            return energySolutionEntities;
        } catch (Exception ex) {
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
            ResultSet rs = Query.executeQuery();
            while (rs.next()) {
                TransportEntity transport = new TransportEntity();
                transport.setUnique_id(rs.getInt("unique_id"));
                transport.setTransportCapacityMax(rs.getString("transp_capacity_max"));
                transport.setTransportCapacityHired(rs.getString("trans_capacity_hired"));
                transport.setTransportVolumen(rs.getString("trans_vol_trans"));
                transport.setTransportLengthpipeline(rs.getString("trans_length_pipeline"));
                transportEntities.add(transport);
            }
            return transportEntities;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            closeConnection();
        }
    }
}
