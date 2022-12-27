package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;
import com.promigas.persistence.entity.OpportunitiesEntity;
import com.promigas.persistence.entity.operatingFinancial.DistributionEntity;
import com.promigas.persistence.entity.operatingFinancial.EnergySolutionEntity;
import com.promigas.persistence.entity.operatingFinancial.TransportEntity;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public class OperatingRepositoryImp extends AbstractRepositoryDatabase implements OperatingRepository {
    private static final String QUERY_DISTRIBUTION = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_ENERGY = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_TRANSPORT = "select * from dbo.cf_capex c where c.id_opportunity=?";


    @Override
    public List<DistributionEntity> findByDistribution(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<EnergySolutionEntity> findByEnergy(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<TransportEntity> findByTransport(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }
}
