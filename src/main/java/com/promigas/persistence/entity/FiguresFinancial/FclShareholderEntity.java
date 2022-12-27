package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class FclShareholderEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String shareholderUsd;
    private String valueShareUsd;
    private String shareholderCop;
    private String valueShareCop;
}
