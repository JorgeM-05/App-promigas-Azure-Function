package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TirEquityEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private Date year;
    private String tirEqFig;
    private String tirEqUnit;
    private String tirEqCapital;
    private String tirEqCost;
    private String tirEqAmortizacion;
}
