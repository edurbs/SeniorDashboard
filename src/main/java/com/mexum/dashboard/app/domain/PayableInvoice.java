package com.mexum.dashboard.app.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "SAPIENS.E501TCP")
public class PayableInvoice {

    @Column(name = "VlrAbe", precision = 15, scale = 2)
    private BigDecimal balanceDue;

    @Column(name="NumCcr", precision = 8)
    private Integer contractNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="TitCar", length = 1)
    private YesNo contractGracePeriod;
}
