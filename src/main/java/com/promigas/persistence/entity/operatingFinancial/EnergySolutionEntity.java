package com.promigas.persistence.entity.operatingFinancial;


import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;

@Data
public class EnergySolutionEntity {

    private int unique_id;
    private OpportunitiesEntity idOpportunity;
    private String solEnergyPowerUnit;
    private String solEnergyPowerFigure;
    private String solGenerUnit;
    private String solGenerFigure;
    private String solDegradation;
    private String solEnergyHourSun;
}
