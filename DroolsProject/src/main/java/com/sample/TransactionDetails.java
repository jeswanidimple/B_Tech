package com.sample;

import java.util.Date;

public class TransactionDetails {

	private long cardNum;
	private long time;
	private String city;
	private int amount;
	private int maxLimit;
	private int fScore;
	private String name;
	private int expmon;
	private int expyear;
	private int pin;
	public static String MetroCities[] = {"mumbai","pune","banglore","delhi","kolkata","guwhati","chennai"};

    public String getCity() {
    	return city;
    }
    public void setCity(String city) {
    	this.city = city;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    
    public long getCardNum() {
    	return cardNum;	
    }
    public void setCardNum(long cardNum) {
    	this.cardNum = cardNum;
    }
    public long getTime() {
    	return time;	
    }
    public void setTime(long time) {
    	this.time = time;
    }
    public int getAmount() {
    	return amount;
    }
    public void setAmount(int amount) {
    	this.amount = amount;
    }
    public int getMaxLimit() {
    	return maxLimit;
    }
    public void setMaxLimit(int maxLimit) {
    	this.maxLimit = maxLimit;
    }
    public int getExpyear() {
    	return expyear;
    }
    public void setExpyear(int expyear) {
    	this.expyear = expyear;
    }
    public int getExpmon() {
    	return expmon;
    }
    public void setExpmon(int expmon) {
    	this.expmon = expmon;
    }
    public int getPin() {
    	return pin;
    }
    public void setPin(int pin) {
    	this.pin = pin;
    }
    
    public int getFScore() {
    	return fScore;
    }
    public void setFScore(int fScore) {
    	this.fScore = fScore;
    }
}
