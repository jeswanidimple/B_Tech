package com.sample;

public class AccountDetails {
	private long cardNumber;
	private String name;
	private int expMonth;
	private int expYear;
	private int pin;
	
	public long getCardNumber() {
    	return cardNumber;
    }
    public void setCardNumber(long cardNumber) {
    	this.cardNumber = cardNumber;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public int getExpMonth() {
    	return expMonth;
    }
    public void setExpMonth(int expMonth) {
    	this.expMonth = expMonth;
    }
    public int getExpYear() {
    	return expYear;
    }
    public void setExpYear(int expYear) {
    	this.expYear = expYear;
    }
    public int getPin() {
    	return pin;
    }
    public void setPin(int pin) {
    	this.pin = pin;
    }
	
}
