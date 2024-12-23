package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reimbursement")
public class Reimbursement
{
	@Column(name = "reimbursementId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reimbursementId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne()
	@JoinColumn(name = "account")
	private Account account;
	
	public Reimbursement()
	{
		
	}
	
	public Reimbursement(Long reimbursementId)
	{
		this.reimbursementId = reimbursementId;
	}
	
	public Long getReimbursementId()
	{
		return reimbursementId;
	}
	
	public void setReimbursementId(Long reimbursementId)
	{
		this.reimbursementId = reimbursementId;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Integer getAmount()
	{
		return amount;
	}
	
	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public Account getAccount()
	{
		return account;
	}
	
	public void setAccount(Account account)
	{
		this.account = account;
	}
}
