package com.mexum.dashboard.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SupplierBalanceDTO {
    private Integer id;
    private String tradeName;
    private BigDecimal balance;
}
