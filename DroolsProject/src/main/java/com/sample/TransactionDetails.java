package com.sample;

import java.util.Date;

public class TransactionDetails {

	private long cardNum;
	private long time;
	private String city;
	private int amount;
	private int maxLimit;
	private int year;
	private int fScore;
	public static String MetroCities[] = {"mumbai","pune","banglore","delhi","kolkata","guwhati","chennai"};

    public String getCity() {
    	return city;
    }
    public void setCity(String city) {
    	this.city = city;
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
    public int getYear() {
    	return year;
    }
    public void setYear(int year) {
    	this.year = year;
    }
    public int getFScore() {
    	return fScore;
    }
    public void setFScore(int fScore) {
    	this.fScore = fScore;
    }
}
