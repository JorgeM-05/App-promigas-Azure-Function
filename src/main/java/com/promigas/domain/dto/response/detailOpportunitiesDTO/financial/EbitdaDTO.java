package com.promigas.domain.dto.response.detailOpportunitiesDTO.financial;

import lombok.Data;

import java.util.List;

@Data
public class EbitdaDTO {

    public List<String> valueEbitdaUsd;
    public List<String> valueEbitdaCop;
}
