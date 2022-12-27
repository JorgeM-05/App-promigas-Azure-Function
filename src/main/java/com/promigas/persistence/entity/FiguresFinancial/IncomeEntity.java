package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class IncomeEntity {
    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String incomeUsd;
    private String valueIncomeUsd;
    private String incomeCop;
    private String valueIncomeCop;
}
