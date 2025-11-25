package com.mexum.dashboard.app.service;

import com.mexum.dashboard.app.dto.OutstandingInvoicesDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FundraisingServiceTest {

    @Autowired
    FundraisingService fundraisingService;

    @Test
    void getOutstandingInvoicesOfSupplier() {
        Integer supplierId = 5241;
        List<OutstandingInvoicesDTO> outstandingInvoicesOfSupplier = fundraisingService.getOutstandingInvoicesOfSupplier(supplierId);
        assertNotNull(outstandingInvoicesOfSupplier);
    }

//    @Test
//    void getOutstandingInvoices() {
//        List<OutstandingInvoicesDTO> outstandingInvoices = fundraisingService.getAllOutstandingInvoices();
//        assertNotNull(outstandingInvoices);
//    }



}