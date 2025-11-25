package com.mexum.dashboard.app.service;

import com.mexum.dashboard.app.dto.SupplierBalanceDTO;
import com.mexum.dashboard.infra.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierBalanceDTO> getSuppliersWithBalance(){
        return supplierRepository.findSuppliersWithBalance();
    }
}
