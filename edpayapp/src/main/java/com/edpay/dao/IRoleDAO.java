package com.edpay.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edpay.model.Roles;

@Repository
public interface IRoleDAO extends JpaRepository<Roles, Serializable>{
	
	public Roles findByRoleId(Long roleId);

}
