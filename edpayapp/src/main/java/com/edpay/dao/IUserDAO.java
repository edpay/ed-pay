package com.edpay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edpay.model.User;


@Repository
public interface IUserDAO extends JpaRepository<User, Long> {
	
	public User findByEmailAddressAndStatus(String email,int status);
	public User findByUserId(Long userId);
	public List<User> findAll();
	public User findByEmailAddress(String emailAddress);
}
