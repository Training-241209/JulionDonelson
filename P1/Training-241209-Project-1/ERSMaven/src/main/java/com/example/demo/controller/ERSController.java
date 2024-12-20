package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.entity.Reimbursement;
import com.example.demo.service.ReimbursementService;
import com.example.demo.service.JwtService;

import java.util.List;

@RestController
public class ERSController
{
	private final AccountService accountService;
	private final ReimbursementService reimbursementService;
	private final JwtService jwtService;
	
	@Autowired
	public ERSController(AccountService accountService, ReimbursementService reimbursementService, JwtService jwtService)
	{
		this.accountService = accountService;
		this.reimbursementService = reimbursementService;
		this.jwtService = jwtService;
	}
	
	/*@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseEntity<String> authenticator(@RequestBody Account account) throws Exception
	{
		try
		{
			
		}
		catch (Exception e)
		{
			throw new Exception("Incorrect username or password", e);
		}
		
		final String jwt = jwtService.generateToken(account);
		
		return new ResponseEntity<>(jwt, HttpStatus.OK);
	}*/
	
	@PostMapping("/register")
	public ResponseEntity<Account> registerAccount(@RequestBody Account account)
	{
		if (accountService.accountCheck(account.getUsername()))
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		else if (account.getUsername() == "" || account.getPassword().length() < 4)
		{
			return new ResponseEntity<>(HttpStatus.valueOf(400));
		}
		else
		{
			Account newAccount = accountService.registerAccount(account);
			return new ResponseEntity<>(newAccount, HttpStatus.OK);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginAccount(@RequestBody Account account)
	{
		Account logAccount = accountService.loginAccount(account.getUsername(), account.getPassword());
		
		if (logAccount != null)
		{
			final String jwt = jwtService.generateToken(logAccount);
			return new ResponseEntity<>(jwt, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/reimbursement")
	public ResponseEntity<Reimbursement> createTicket(@RequestBody Reimbursement reimbursement)
	{
		Reimbursement newReimbursement = reimbursementService.createTicket(reimbursement);
		return new ResponseEntity<>(newReimbursement, HttpStatus.OK);
	}
	
	@PatchMapping("/reimbursement/approve")
	public ResponseEntity<Reimbursement> approveTicket(@RequestBody Reimbursement reimbursement)
	{
		/*if (reimbursement.getAccount() == null || reimbursement.getAccount().getRole().getTitle() != "Manager")
		{
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		else
		{*/
			Reimbursement approved = reimbursementService.approveTicket(reimbursement);
			
			if (approved != null)
			{
				return new ResponseEntity<>(approved, HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(approved, HttpStatus.valueOf(400));
			}
		//}
	}
}
