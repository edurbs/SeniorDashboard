package com.mexum.dashboard.infra.repository;

import com.mexum.dashboard.app.domain.PayableInvoice;
import com.mexum.dashboard.app.domain.PayableInvoiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PayableInvoiceRepository extends JpaRepository<PayableInvoice, PayableInvoiceId>, JpaSpecificationExecutor<PayableInvoice> {
}
