package com.example.demo.entity;

import jakarta.persistence.*;

import com.example.demo.entity.Account;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "role")
public class Role
{
	@Column(name = "roleId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;
	
	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Account> accounts = new HashSet<>();
	
	public Role()
	{
		
	}
	
	public Role(Long roleId, String title)
	{
		this.roleId = roleId;
		this.title = title;
	}
	
	public Long getRoleId()
	{
		return roleId;
	}
	
	public String getTitle()
	{
		return title;
	}
}
