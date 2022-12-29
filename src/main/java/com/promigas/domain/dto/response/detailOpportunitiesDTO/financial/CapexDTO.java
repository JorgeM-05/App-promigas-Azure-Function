package com.promigas.domain.dto.response.detailOpportunitiesDTO.financial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

import java.util.List;

@Data
public class CapexDTO {
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String capexUsd;
    private String capexCop;
    private List<String> valueCapexUsd;
    private List<String> valueCapexCop;
}
