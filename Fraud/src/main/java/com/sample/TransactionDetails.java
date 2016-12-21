package com.sample;

public class TransactionDetails {
 
   private long cardnum;
   private int amount;
   private String city;
   private int maxlimit;
   public static String MetroCities[] = {"mumbai","delhi","banglore","pune","kolkata","chennai","guwhati"};
      
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
}