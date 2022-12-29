package com.promigas.domain.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ListOpportunitiesFilter {
    private List<ListOpportunitiesDto> listOportunitiesByCountries;

}
