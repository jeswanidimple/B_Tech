package com.sample;

public class TransactionDetails {

	private long cardnum;
	private String city;
	private int amount;
	private int maxlimit;
	private int year;
	public static String MetroCities[] = {"mumbai","pune","banglore","delhi","kolkata","guwhati","chennai"};

    public String getCity() {
    	return city;
    }
    public void setCity(String city) {
    	this.city = city;
    }
    public long getCardNumber() {
    	return cardnum;	
    }
    public void setCardNumber(long cardnum) {
    	this.cardnum = cardnum;
    }
    public int getAmount() {
    	return amount;
    }
    public void setAmount(int amount) {
    	this.amount = amount;
    }
    public int getMaxLimit() {
    	return maxlimit;
    }
    public void setMaxLimit(int maxlimit) {
    	this.maxlimit = maxlimit;
    }
    public int getYear() {
    	return year;
    }
    public void setYear(int year) {
    	this.year = year;
    }
    
}
