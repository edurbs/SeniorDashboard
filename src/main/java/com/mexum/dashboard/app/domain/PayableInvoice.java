package com.mexum.dashboard.app.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "SAPIENS.E501TCP")
@IdClass(PayableInvoiceId.class)
public class PayableInvoice {

    @Id
    @Column(name = "CodEmp", nullable = false, precision = 4)
    private int companyId;

    @Id
    @Column(name = "CodFil", nullable = false, precision = 5)
    private int branchId;

    @Id
    @Size(max = 15)
    @Column(name = "NumTit", nullable = false, length = 15)
    private String invoiceNumber;

    @Id
    @Size(max = 3)
    @Column(name = "CodTpt", nullable = false, length = 3)
    private String invoiceId;

    @Id
    @Column(name = "CodFor", nullable = false, precision = 9)
    private int supplierId;

    @Column(name = "VlrAbe", precision = 15, scale = 2)
    private BigDecimal balanceDue;

    @Column(name="NumCcr", precision = 8)
    private Integer contractNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="TitCar", length = 1)
    private YesNo contractGracePeriod;
}

