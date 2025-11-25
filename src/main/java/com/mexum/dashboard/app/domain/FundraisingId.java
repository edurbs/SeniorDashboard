package com.mexum.dashboard.app.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class FundraisingId implements Serializable {
    private int companyCode;
    private int branchCode;
    private int contractNumber;
}
