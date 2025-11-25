package com.mexum.dashboard.app.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "SAPIENS.E606CCR")
@IdClass(FundraisingId.class)
public class Fundraising {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CodEmp", nullable = false, precision = 4)
    private int companyCode;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CodFil", nullable = false, precision = 5)
    private int branchCode;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "NumCcr", nullable = false, precision = 8)
    private int contractNumber;

//    @Column(name = "CodFor", precision = 9)
//    private Integer supplyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodFor", referencedColumnName = "CodFor", insertable = false, updatable = false)
    private Supplier supplier;
}

