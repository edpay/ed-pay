package com.edpay.data.type;

/**
 * @author vedavyasa
 *
 */
public enum StatusCode {

	ACTIVE(1),
	IN_ACTIVE(2),
	BLOCKED(3);

	public int status;

	private StatusCode(int status) {
		this.status = status;
	}

	public int getStatusCode(){
		return status;
	}

}
