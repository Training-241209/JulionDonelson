package com.example.demo.repository;

import com.example.demo.entity.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReimbursementRepository extends JpaRepository<Reimbursement, Long>
{
	Optional<Reimbursement> findByReimbursementId(Long reimbursementId);
}
