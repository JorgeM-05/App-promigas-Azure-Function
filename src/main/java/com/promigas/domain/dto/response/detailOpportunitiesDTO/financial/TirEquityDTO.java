package com.promigas.domain.dto.response.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;
@Data
public class TirEquityDTO {
    public int unique_id;
    public List<String> valueTarifUsd;
    public List<String> valueTarifCop;
}
