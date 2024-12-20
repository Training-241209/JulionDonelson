package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<Role, Long>
{
	@Query("FROM Role WHERE roleId = :id")
	Role customFindById(@Param("id") Long id);
	
	Role findByTitle(String title);
}
