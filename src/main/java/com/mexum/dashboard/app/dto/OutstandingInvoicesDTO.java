package com.mexum.dashboard.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class OutstandingInvoicesDTO {

    private Integer contractId;
    private String bankContractNumber;
    private Timestamp contractDate;
    private String contractDescription;
    private BigDecimal balance;

    public LocalDate getContractDate() {
        return contractDate.toLocalDateTime().toLocalDate();
    }

}
