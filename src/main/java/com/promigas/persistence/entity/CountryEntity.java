package com.promigas.persistence.entity;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

@Data
public class CountryEntity {
    private int unique_id;
    private String nameContry;
}
