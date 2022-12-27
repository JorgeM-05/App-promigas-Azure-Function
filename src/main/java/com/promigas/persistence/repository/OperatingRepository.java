package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.FiguresFinancial.CapexEntity;

import java.util.List;

public interface OperatingRepository {
    public List<CapexEntity> findByDistribution(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByEnergy(int id_opportunity, ConnectionInfo connectionInfo);
    public List<CapexEntity> findByTransport(int id_opportunity, ConnectionInfo connectionInfo);

}
