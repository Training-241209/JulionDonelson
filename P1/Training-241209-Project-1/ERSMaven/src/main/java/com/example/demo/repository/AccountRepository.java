package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>
{
	@Query("FROM Account WHERE accountId = :id")
	List<Account> customFindById(@Param("id") Long id);
	
	Optional<Account> findByUsername(String username);
	Optional<Account> findByUsernameAndPassword(String username, String password);
}
