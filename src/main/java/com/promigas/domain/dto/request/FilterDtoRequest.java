package com.promigas.domain.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class FilterDtoRequest {
    private List<Country> countries;
    private List<Sector> sectors;
    private String greenfield;
    private String mya;
    private int minCapex;
    private int MaxCapex;

}
