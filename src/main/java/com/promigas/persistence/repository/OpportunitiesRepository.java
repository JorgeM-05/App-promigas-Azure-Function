package com.promigas.persistence.repository;

import com.promigas.domain.dto.ConnectionInfo;
import com.promigas.persistence.entity.OpportunitiesEntity;

import java.util.List;

public interface OpportunitiesRepository {
    public List<OpportunitiesEntity> findByIdCountry(String country, ConnectionInfo connectionInfo);

//    public OpportunitiesEntity findById(Integer id, ConnectionInfo connectionInfo);
}
