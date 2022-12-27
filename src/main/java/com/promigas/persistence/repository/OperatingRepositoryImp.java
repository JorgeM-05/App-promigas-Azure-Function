package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;
import com.promigas.persistence.entity.OpportunitiesEntity;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

public class OperatingRepositoryImp extends AbstractRepositoryDatabase implements OperatingRepository {
    private static final String QUERY_DISTRIBUTION = "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_ENERGY= "select * from dbo.cf_capex c where c.id_opportunity=?";
    private static final String QUERY_TRANSPORT = "select * from dbo.cf_capex c where c.id_opportunity=?";


    @Override
    public List<CapexEntity> findByDistribution(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByEnergy(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }

    @Override
    public List<CapexEntity> findByTransport(int id_opportunity, ConnectionInfo connectionInfo) {
        return null;
    }
}
