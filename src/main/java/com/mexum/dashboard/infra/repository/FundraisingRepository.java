package com.mexum.dashboard.infra.repository;

import com.mexum.dashboard.app.domain.Fundraising;
import com.mexum.dashboard.app.domain.FundraisingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FundraisingRepository extends JpaRepository<Fundraising, FundraisingId>, JpaSpecificationExecutor<Fundraising> {
}
