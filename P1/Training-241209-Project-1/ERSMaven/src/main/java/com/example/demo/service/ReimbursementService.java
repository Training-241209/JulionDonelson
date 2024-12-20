package com.example.demo.service;

import com.example.demo.entity.Reimbursement;
import com.example.demo.repository.ReimbursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReimbursementService
{
	ReimbursementRepository reimbursementRepository;
	
	@Autowired
	public ReimbursementService(ReimbursementRepository reimbursementRepository)
	{
		this.reimbursementRepository = reimbursementRepository;
	}
	
	public Reimbursement createTicket(Reimbursement reimbursement)
	{
		return reimbursementRepository.save(reimbursement);
	}
	
	public Reimbursement approveTicket(Reimbursement reimbursement)
	{
		Optional<Reimbursement> approval = reimbursementRepository.findByReimbursementId(reimbursement.getReimbursementId());
		if (approval.isPresent())
		{
			Reimbursement newReimbursement = approval.get();
			newReimbursement.setStatus("approved");
			return reimbursementRepository.save(newReimbursement);
		}
		else
		{
			return null;
		}
	}
}
