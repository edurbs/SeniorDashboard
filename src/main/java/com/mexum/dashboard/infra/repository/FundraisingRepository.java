package com.mexum.dashboard.infra.repository;

import com.mexum.dashboard.app.domain.Fundraising;
import com.mexum.dashboard.app.domain.FundraisingId;
import com.mexum.dashboard.app.dto.OutstandingInvoicesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FundraisingRepository extends JpaRepository<Fundraising, FundraisingId>, JpaSpecificationExecutor<Fundraising> {
    
    @Query(value = """
            SELECT 
                c.NUMCCR,
                c.NUMCBO,
                c.DATCCR,
                c.DESCCR,
                COALESCE(t.actualBalance, 0) AS balance
            FROM 
                SAPIENS.E606CCR c
            INNER JOIN 
                SAPIENS.E095FOR f ON c.CODFOR = f.CODFOR
            LEFT JOIN (
                SELECT 
                    NUMCCR, 
                    SUM(VLRABE) AS actualBalance
                FROM 
                    SAPIENS.E501TCP
                WHERE 
                    TITCAR = 'N'
                GROUP BY 
                    NUMCCR
            ) t ON c.NUMCCR = t.NUMCCR
            WHERE
                COALESCE(t.actualBalance, 0) > 0 
                AND f.CODFOR = :supplierId
            ORDER BY 
                balance desc
            """, nativeQuery = true)
    List<OutstandingInvoicesDTO> findOutstandingInvoicesOfSupplier(@Param("supplierId") Integer supplierId);

    @Query(value = """
            SELECT 
                c.NUMCCR,
                c.NUMCBO,
                c.DATCCR,
                c.DESCCR,
                COALESCE(t.actualBalance, 0) AS balance
            FROM 
                SAPIENS.E606CCR c
            INNER JOIN 
                SAPIENS.E095FOR f ON c.CODFOR = f.CODFOR
            LEFT JOIN (
                SELECT 
                    NUMCCR, 
                    SUM(VLRABE) AS actualBalance
                FROM 
                    SAPIENS.E501TCP
                WHERE 
                    TITCAR = 'N'
                GROUP BY 
                    NUMCCR
            ) t ON c.NUMCCR = t.NUMCCR
            WHERE
                COALESCE(t.actualBalance, 0) > 0
            ORDER BY 
                balance desc
            """,
            nativeQuery = true)
    List<OutstandingInvoicesDTO> findAllOutstandingInvoices();
}
