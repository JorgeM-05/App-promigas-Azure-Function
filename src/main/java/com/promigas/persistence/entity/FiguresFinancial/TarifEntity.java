package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class TarifEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String valueTarifUsd;
    private String valueTarifCop;
}
