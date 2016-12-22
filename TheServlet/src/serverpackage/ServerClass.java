package serverpackage;

import com.sample.*;

public class ServerClass {

	public static TransactionDetails userdetail = new TransactionDetails();
	
	public static void fetchdetails(long cardnum, String city, int amount)
	{
			userdetail.setCardNumber(cardnum);
			userdetail.setCity(city);
			userdetail.setAmount(amount);
			System.out.println("Setting Values");
			System.out.println("Card Number : " + userdetail.getCardNumber());
			System.out.println("City : " + userdetail.getCity());
			System.out.println("Amount : " + userdetail.getAmount());
			System.out.println("Initial Max Limit : " + userdetail.getMaxLimit());
	}

	public static int main(String[] args) {
		// TODO Auto-generated method stub
		
			new DroolsTest().ApplyRule(userdetail);
			int maxlimit = userdetail.getMaxLimit();
			System.out.println("Maximum limit set to - " + maxlimit);
		
			//Validating the transaction
		
			if(userdetail.getAmount() > maxlimit) {
				return 1;
			}
			else {
				return 0;
			}		
	}
}