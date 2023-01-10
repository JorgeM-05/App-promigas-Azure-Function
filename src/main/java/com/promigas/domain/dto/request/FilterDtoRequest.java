package com.promigas.domain.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class FilterDtoRequest {
    private List<CountryDto> countries;
    private List<SectorDto> sectorDtos;
    private String greenfield;
    private String mya;
    private int minCapex;
    private int MaxCapex;

}
