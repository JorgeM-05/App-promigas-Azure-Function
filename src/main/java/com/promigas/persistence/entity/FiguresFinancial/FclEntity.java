package com.promigas.persistence.entity.FiguresFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class FclEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String year;
    private String fclUsd;
    private String valueFclUsd;
    private String fclCop;
    private String valueFclCop;
}
