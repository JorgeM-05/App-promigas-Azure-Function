package com.promigas.persistence.entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SectorEntity {
    private int unique_id;
    private String typeSector;
}
