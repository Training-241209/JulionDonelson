package com.example.demo.dto.response;

import com.example.demo.entity.Account;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse
{
	Long accountId;
	String username;
	String role;
	
	public AccountResponse()
	{
		
	}
	
	public AccountResponse(Long accountId, String username, String role)
	{
		this.accountId = accountId;
		this.username = username;
		this.role = role;
	}
	
	public AccountResponse(Account account)
	{
		this.accountId = account.getAccountId();
		this.username = account.getUsername();
		this.role = account.getRole().getTitle();
	}
	
	public Long getAccountId()
	{
		return accountId;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getRole()
	{
		return role;
	}
}
