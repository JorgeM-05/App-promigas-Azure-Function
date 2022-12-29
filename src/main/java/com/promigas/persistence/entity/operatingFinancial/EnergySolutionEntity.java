package com.promigas.persistence.entity.operatingFinancial;


import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class EnergySolutionEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String solEnergyPowerUnit;
    private float solEnergyPowerFigure;
    private String solGenerUnit;
    private float solGenerFigure;
    private float solDegradation;
    private float solEnergyHourSun;
}
