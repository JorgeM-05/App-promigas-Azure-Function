package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class EbitdaEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String ebitdaUsd;
    private String valueEbitdaUsd;
    private String ebitdaCop;
    private String valueEbitdaCop;
}
