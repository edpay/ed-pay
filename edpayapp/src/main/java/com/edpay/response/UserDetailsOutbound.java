package com.edpay.response;

public class UserDetailsOutbound {

	Long userId;
	
	String emailId;
	
	String userName;
	
	String userRole;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetailsOutbound [userId=" + userId + ", emailId=" + emailId
				+ ", userName=" + userName + ", userRole=" + userRole + "]";
	}
	
	

}
