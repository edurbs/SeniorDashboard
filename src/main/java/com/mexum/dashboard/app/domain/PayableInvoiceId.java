package com.mexum.dashboard.app.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PayableInvoiceId implements Serializable {
    private int companyId;
    private int branchId;
    private String invoiceNumber;
    private String invoiceId;
    private int supplierId;
}
