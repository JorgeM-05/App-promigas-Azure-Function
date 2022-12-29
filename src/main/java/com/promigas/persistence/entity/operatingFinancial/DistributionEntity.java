package com.promigas.persistence.entity.operatingFinancial;


import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
public class DistributionEntity {

    private int unique_id;
    private OpportunitiesEntity idOportunity;
    private String volumeDistribution;
    private int distriPeriod;
    private String distributionKms;
    private int distributionUsers;
    private String distributionPenetration;

}
