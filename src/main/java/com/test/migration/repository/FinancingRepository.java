package com.test.migration.repository;

import com.test.migration.model.Financing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancingRepository extends JpaRepository<Financing, Integer> {
}
