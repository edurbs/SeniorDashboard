package com.mexum.dashboard.app.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @Column(name="CodEmp", nullable = false, precision = 4)
    private Integer companyId;


    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Column(name="CodFil", nullable = false, precision = 5)
    private Integer branchId;

    @Id
    @EqualsAndHashCode.Include
    @NotNull
    @Column(name="NumCcr", nullable = false, precision = 8)
    private Integer contractId;

}

