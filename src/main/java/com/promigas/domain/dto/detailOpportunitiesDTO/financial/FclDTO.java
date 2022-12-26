package com.promigas.domain.dto.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;

@Data
public class FclDTO {
    public int unique_id;
    public List<String> valueFclUsd;
    public List<String> valueFclCop;
}
