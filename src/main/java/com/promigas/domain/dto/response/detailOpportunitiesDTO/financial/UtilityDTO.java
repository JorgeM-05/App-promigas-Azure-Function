package com.promigas.domain.dto.response.detailOpportunitiesDTO.financial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class UtilityDTO {

    private OpportunitiesEntity idoportunity;
    private float utilityUsd;
    private float valueUtilityUsd;
    private float utilityCop;
    private float valueUtilityCop;
}
