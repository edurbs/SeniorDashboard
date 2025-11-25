package com.mexum.dashboard.app.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "SAPIENS.E501TCP")
@IdClass(PayableInvoiceId.class)
public class PayableInvoice {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CodEmp", nullable = false, precision = 4)
    private int companyId;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "CodFil", nullable = false, precision = 5)
    private int branchId;

    @Id
    @EqualsAndHashCode.Include
    @Size(max = 15)
    @Column(name = "NumTit", nullable = false, length = 15)
    private String invoiceNumber;

    @Id
    @EqualsAndHashCode.Include
    @Size(max = 3)
    @Column(name = "CodTpt", nullable = false, length = 3)
    private String invoiceId;

//    @Id
//    @EqualsAndHashCode.Include
//    @Column(name = "CodFor", nullable = false, precision = 9)
//    private int supplierId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodFor", referencedColumnName = "CodFor", insertable = false, updatable = false, nullable = false)
    private Supplier supplier;

    @Column(name = "VlrAbe", precision = 15, scale = 2)
    private BigDecimal balanceDue;

    @Column(name="NumCcr", precision = 8)
    private Integer contractNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="TitCar", length = 1)
    private YesNo contractGracePeriod;
}

