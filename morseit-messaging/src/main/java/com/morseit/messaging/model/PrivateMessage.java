package com.morseit.messaging.model;



/**
 * @author Harsh
 *
 */
public class PrivateMessage {
	
	
	private String message;
	private String sender;
	private String reciever;
	private String sentDate;
	private String uUID;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public String getSentDate() {
		return sentDate;
	}
	public void setSentDate(String sentDate) {
		this.sentDate = sentDate;
	}
	public String getuUID() {
		return uUID;
	}
	public void setuUID(String uUID) {
		this.uUID = uUID;
	}

}
