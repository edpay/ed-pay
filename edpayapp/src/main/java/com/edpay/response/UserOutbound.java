package com.edpay.response;

public class UserOutbound {
	
	private Long userId;
	
	private String userName;
	
	private String emailAddress;
	
	private String Date;
	
	private Integer Status;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Integer getStatus() {
		return Status;
	}

	public void setStatus(Integer status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "UserOutbound [userId=" + userId + ", userName=" + userName
				+ ", emailAddress=" + emailAddress + ", Date=" + Date
				+ ", Status=" + Status + "]";
	}
	
	

}
