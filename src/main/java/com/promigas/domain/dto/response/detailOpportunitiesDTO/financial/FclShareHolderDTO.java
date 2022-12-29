package com.promigas.domain.dto.response.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;
@Data
public class FclShareHolderDTO {
    public int unique_id;
    public List<String> valueShareUsd;
    public List<String> valueShareCop;
}
