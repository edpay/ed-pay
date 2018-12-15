package com.edpay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ep_userRole")
public class UserRole {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="user_role_map_id", length = 15)
	private Long userRoleMapId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	Roles role;

	public Long getUserRoleMapId() {
		return userRoleMapId;
	}

	public void setUserRoleMapId(Long userRoleMapId) {
		this.userRoleMapId = userRoleMapId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [userRoleMapId=" + userRoleMapId + ", user=" + user
				+ ", role=" + role + "]";
	}
	
	

}
