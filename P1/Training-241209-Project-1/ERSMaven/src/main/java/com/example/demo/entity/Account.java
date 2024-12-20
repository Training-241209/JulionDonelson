package com.example.demo.entity;

import jakarta.persistence.*;

import com.example.demo.entity.Reimbursement;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "account")
public class Account
{
	@Column(name = "accountId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne()
	@JoinColumn(name = "role")
	private Role role;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private Set<Reimbursement> reimbursements = new HashSet<>();
	
	public Account()
	{
		
	}
	
	public Account(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public Account(Long accountId, String username)
	{
		this.accountId = accountId;
		this.username = username;
	}
	
	public Account(Long accountId, String username, String password)
	{
		this.accountId = accountId;
		this.username = username;
		this.password = password;
	}
	
	public Long getAccountId()
	{
		return accountId;
	}
	
	public void setAccountId(Long accountId)
	{
		this.accountId = accountId;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public Role getRole()
	{
		return role;
	}
	
	public void setRole(Role role)
	{
		this.role = role;
	}
}
