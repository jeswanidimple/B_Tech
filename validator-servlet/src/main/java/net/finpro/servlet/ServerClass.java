package net.finpro.servlet;

import com.sample.*;

public class ServerClass {

	public int fetchdetails(long cardnum, String city, int amount, int expyear, long time, String name,int pin,int expmon)
	{
		TransactionDetails userdetail = new TransactionDetails();
			userdetail.setCardNum(cardnum);
			userdetail.setCity(city);
			userdetail.setAmount(amount);
			userdetail.setTime(time);
			userdetail.setExpmon(expmon);
			userdetail.setExpyear(expyear);
			userdetail.setPin(pin);
			userdetail.setName(name);
			userdetail.setFScore(0);
			//VJ: This was missing
			int FRate = new ApplyDrools().RunDrools(userdetail);
			return FRate;
	}
}