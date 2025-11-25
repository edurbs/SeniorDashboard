package com.mexum.dashboard.infra.repository;

import com.mexum.dashboard.app.domain.Supplier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupplierRepository extends JpaRepository<Supplier, Long>, JpaSpecificationExecutor<Supplier> {
    Slice<Supplier> findAllBy(Pageable pageable);
}
