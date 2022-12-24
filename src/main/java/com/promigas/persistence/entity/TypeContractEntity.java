package com.promigas.persistence.entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class TypeContractEntity {
    private int unique_id;
    private String typeContract;
}
