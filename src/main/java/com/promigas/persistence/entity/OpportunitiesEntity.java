package com.promigas.persistence.entity;

import lombok.Data;

@Data
public class OpportunitiesEntity {
    private int unique_id;
    private CountryEntity idCountry;
    private SectorEntity idSector;
    private TypeContractEntity idContract;
    private String greenfield;
    private String MYA;
    private String projecTitle;
    private String date;
    private String coordinates;
    private String descrip;
    private String section;
    private String horizonope;
    private String horizonpre;
    private String poc;
    private String trmBase;
    private String trmFin;
    private String propCapexUsd;
    private String propCapexCop;
    private String financilAsset;
}
