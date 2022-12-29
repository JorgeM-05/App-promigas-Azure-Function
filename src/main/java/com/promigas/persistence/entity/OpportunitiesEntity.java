package com.promigas.persistence.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OpportunitiesEntity {
    private int unique_id;
    private CountryEntity idCountry;
    private SectorEntity idSector;
    private TypeContractEntity idContract;
    private boolean greenfield;
    private boolean MYA;
    private String projecTitle;
    private String date; //cambiar Date
    private String coordinates;
    private String descrip;
    private String section;
    private int horizonope;
    private int horizonpre;
    private String poc; //cambiar Date
    private float trmBase;
    private float trmFin;
    private float propCapexUsd;
    private float propCapexCop;
    private int financilAsset;
}
