package net.finpro.servlet;

import com.sample.*;

public class ServerClass {

	public int fetchdetails(long cardnum, String city, int amount, int year, long time)
	{
		TransactionDetails userdetail = new TransactionDetails();
			userdetail.setCardNum(cardnum);
			userdetail.setCity(city);
			userdetail.setAmount(amount);
			userdetail.setYear(year);
			userdetail.setTime(time);


			//VJ: This was missing
			int FRate = new ApplyDrools().RunDrools(userdetail);
			return FRate;
	}
}