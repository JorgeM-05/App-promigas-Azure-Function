package com.promigas.domain.dto.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;

@Data
public class CapexDTO {
//    public OpportunitiesEntity idOpportunity;
//    public String year;
//    public String capexUsd;
//    public String capexCop;
    public List<String> valueCapexUsd;
    public List<String> valueCapexCop;
}
