package com.promigas.persistence.entity.operatingFinancial;


import com.promigas.persistence.entity.OpportunitiesEntity;
import lombok.Data;



@Data
public class EnergySolutionEntity {

    private int unique_id;
    private OpportunitiesEntity idoportunity;
    private String solenergunit;
    private String solenergfigure;
    private String solgenerfigure;
    private String solgenerunit;
    private String soldegradation;
    private String solenerghoursun;
}
