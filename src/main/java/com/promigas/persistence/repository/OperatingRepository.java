package com.promigas.persistence.repository;

import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.operatingFinancial.DistributionEntity;
import com.promigas.persistence.entity.operatingFinancial.EnergySolutionEntity;
import com.promigas.persistence.entity.operatingFinancial.TransportEntity;

import java.util.List;

public interface OperatingRepository {
    public List<DistributionEntity> findByDistribution(int id_opportunity, ConnectionInfo connectionInfo);
    public List<EnergySolutionEntity> findByEnergy(int id_opportunity, ConnectionInfo connectionInfo);
    public List<TransportEntity> findByTransport(int id_opportunity, ConnectionInfo connectionInfo);

}
