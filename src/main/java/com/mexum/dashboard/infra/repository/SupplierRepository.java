package com.mexum.dashboard.infra.repository;

import com.mexum.dashboard.app.domain.Supplier;
import com.mexum.dashboard.app.dto.SupplierBalanceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {

    @Query(value = """
            SELECT
                f.CODFOR,
                f.APEFOR,
                COALESCE(SUM(t.VLRABE), 0) AS balance
            FROM
                SAPIENS.E095FOR f
            INNER JOIN
                SAPIENS.E606CCR c ON f.CODFOR = c.CODFOR
            LEFT JOIN
                SAPIENS.E501TCP t ON c.NUMCCR = t.NUMCCR AND t.TITCAR = 'N'
            GROUP BY
                f.CODFOR, f.APEFOR
            HAVING
                COALESCE(SUM(t.VLRABE), 0) > 0
            ORDER BY
                balance DESC
            """, nativeQuery = true)
    List<SupplierBalanceDTO> findSuppliersWithBalance();
}
