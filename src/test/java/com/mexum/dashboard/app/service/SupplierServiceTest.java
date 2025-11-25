package com.mexum.dashboard.app.service;

import com.mexum.dashboard.app.dto.SupplierBalanceDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SupplierServiceTest {

    @Autowired
    SupplierService supplierService;

    @Test
    void getSuppliersWithBalance() {
        List<SupplierBalanceDTO> suppliersWithBalance = supplierService.getSuppliersWithBalance();
        Assertions.assertNotNull(suppliersWithBalance);
    }

}