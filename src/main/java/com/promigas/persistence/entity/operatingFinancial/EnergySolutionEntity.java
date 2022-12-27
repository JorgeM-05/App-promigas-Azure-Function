package com.promigas.persistence.entity.operatingFinancial;


import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;



@Data
public class EnergySolutionEntity {

    private int unique_id;
    private OpportunitiesEntity idoportunity;
    private String solenerg_power_unit;
    private String solenerg_power_figure;
    private String solenerg_gener_figure;
    private String solenerg_gener_unit;
    private String solenerg_degradation_average ;
    private String solenerg_hour_sun ;
}
