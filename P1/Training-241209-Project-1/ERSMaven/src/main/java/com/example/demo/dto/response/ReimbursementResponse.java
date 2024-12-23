package com.example.demo.dto.response;

import com.example.demo.entity.Reimbursement;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReimbursementResponse
{
	private Long reimbursementId;
	private String description;
	private int amount;
	private String status;
	private Long accountId;
	
	public ReimbursementResponse ()
	{
		
	}
	
	public ReimbursementResponse(Long id, String des, int amount, String status)
	{
		this.reimbursementId = id;
		this.description = des;
		this.amount = amount;
		this.status = status;
	}
	
	public ReimbursementResponse (Reimbursement reimbursement)
	{
		this.reimbursementId = reimbursement.getReimbursementId();
		this.description = reimbursement.getDescription();
		this.amount = reimbursement.getAmount();
		this.status = reimbursement.getStatus();
		this.accountId = reimbursement.getAccount().getAccountId();
	}
	
	public Long getReimbursementId()
	{
		return reimbursementId;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public int getAmount()
	{
		return amount;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public Long getAccountId()
	{
		return accountId;
	}
}
