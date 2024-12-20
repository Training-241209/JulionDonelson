package com.example.demo.service;

import com.example.demo.entity.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;

import java.security.Key;

import java.util.Date;

@Service
public class JwtService
{
	@Value("${jwt.secret}")
	private String secretKey;
	
	public String generateToken(Account account)
	{
		return Jwts.builder()
				.claim("username", account.getUsername())
				.claim("password", account.getPassword())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
				.signWith(getSignKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public Account decodeToken(String token)
	{
		var claims = Jwts.parserBuilder()
				.setSigningKey(getSignKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		return new Account(claims.get("username", String.class), claims.get("password", String.class));
	}
	
	private Key getSignKey()
	{
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
