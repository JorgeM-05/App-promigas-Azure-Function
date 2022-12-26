package com.promigas.domain.dto.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;
@Data
public class DividensDTO {
    public int unique_id;
    public List<String> valuedividensUsd;
    public List<String> valueDividensCop;
}
