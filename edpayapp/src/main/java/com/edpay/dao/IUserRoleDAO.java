package com.edpay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edpay.model.User;
import com.edpay.model.UserRole;

@Repository
public interface IUserRoleDAO extends JpaRepository<UserRole, Long>{
	
	public UserRole findByUser(User user);

}
