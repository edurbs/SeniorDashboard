package com.mexum.dashboard.app.service;

import com.mexum.dashboard.app.dto.OutstandingInvoicesDTO;
import com.mexum.dashboard.infra.repository.FundraisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundraisingService {

    @Autowired
    private FundraisingRepository fundraisingRepository;

    public List<OutstandingInvoicesDTO> getOutstandingInvoicesOfSupplier(Integer supplierId){
        return fundraisingRepository.findOutstandingInvoicesOfSupplier(supplierId);
    }

    public List<OutstandingInvoicesDTO> getAllOutstandingInvoices(){
        return fundraisingRepository.findAllOutstandingInvoices();
    }

}
