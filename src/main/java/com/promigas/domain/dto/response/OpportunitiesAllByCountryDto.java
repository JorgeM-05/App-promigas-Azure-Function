package com.promigas.domain.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class OpportunitiesAllByCountryDto {
    private int id_country;
    private String country;
    private List<ListOportunitiesByCountry> listOportunitiesByCountries;
}
