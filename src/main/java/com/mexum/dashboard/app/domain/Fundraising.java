package com.mexum.dashboard.app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "SAPIENS.E606CCR")
public class Fundraising {

    @EqualsAndHashCode.Include
    @Column(name = "NumCcr", nullable = false, precision = 8)
    private int contractNumber;

    @Column(name = "CodFor", precision = 9)
    private Integer supplyId;

}
