package com.akhil.model;

public class ResponseModel {
	private int responseCode;
	private String reponseMessage;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getReponseMessage() {
		return reponseMessage;
	}

	public void setReponseMessage(String reponseMessage) {
		this.reponseMessage = reponseMessage;
	}

	@Override
	public String toString() {
		return "ResponseModel [responseCode=" + responseCode + ", reponseMessage=" + reponseMessage + "]";
	}

}
