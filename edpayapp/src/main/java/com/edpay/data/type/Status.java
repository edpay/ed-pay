package com.edpay.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {

	REGISTERED("Registered"),
	SENT("Sent"),
	PENDING("Pending"),
	ACTIVE("Active"),
	EXPIRED("Expired"),
	SUBSCRIBED("Subscribed"),
	APPROVED("Approved"),
	CREATED("Created"),
	ACTIVATION_PENDING("Activation_Pending"),
	INACTIVE("Inactive");
	
	String value;

	public String getValue() {
		return value;
	}

	private Status(String value) {
		this.value= value;
	}

}
