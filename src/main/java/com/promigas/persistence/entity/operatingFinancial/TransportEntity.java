package com.promigas.persistence.entity.operatingFinancial;

import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class TransportEntity {

    private int unique_id;
    private OpportunitiesEntity idoportunity;
    private String transportCapacityMax;
    private String TransportCapacityHired;
    private String TransportVolumen;
    private String TransportLengthpipeline;

}
