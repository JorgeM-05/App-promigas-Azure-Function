package com.promigas.persistence.repository;

import com.promigas.domain.dto.request.FilterDtoRequest;
import com.promigas.domain.dto.response.ConnectionInfo;
import com.promigas.persistence.entity.OpportunitiesEntity;

import java.util.List;

public interface FilterRepository {
    public List<OpportunitiesEntity> findByIdCountry(FilterDtoRequest filterDtoRequest, ConnectionInfo connectionInfo);

}
