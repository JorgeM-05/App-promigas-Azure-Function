package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class UtilityEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String utilityUsd;
    private String valueUtilityUsd;
    private String utilityCop;
    private String valueUtilityCop;
}
