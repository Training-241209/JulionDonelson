package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService
{
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	public AccountService(AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder)
	{
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Account registerAccount(Account account)
	{
		String securePassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(securePassword);
		
		account.setRole(roleRepository.findByTitle("User"));
		
		return accountRepository.save(account);
	}
	
	public Account loginAccount(String username, String password)
	{
		Optional<Account> logAccount = accountRepository.findByUsername(username);
		if (logAccount.isPresent())
		{
			if (passwordEncoder.matches(password, logAccount.get().getPassword()))
			{
				return logAccount.get();
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	public boolean accountCheck(String username)
	{
		return accountRepository.findByUsername(username).isPresent();
	}
	
	public boolean accountCheck(Long id)
	{
		return !accountRepository.customFindById(id).isEmpty();
	}
}
