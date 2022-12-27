package com.promigas.persistence.entity.FiguresFinancial;


import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class CapexEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String capexUsd;
    private String valueCapexUsd;
    private String capexCop;
    private String valueCapexCop;
}
