package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFile {

	AccountDetails ReadCsv(long userCardNum) throws IOException{

		InputStream in = ReadFile.class.getClassLoader().getResourceAsStream("data.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String line = null;
		Scanner scanner = null;

		//long userCardNum = userinfo.getCardNum();   //entered by the user
		AccountDetails actualdetail = new AccountDetails();   //in our database
		int x = 0;
		while ((line = reader.readLine()) !=null) {
			//line = reader.readLine();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			
			while (scanner.hasNext()) {
				String cardnum = scanner.next();
				String name = scanner.next();
				String expm = scanner.next();
				String expy = scanner.next();
				String cvv = scanner.next();
				String pin = scanner.next();
				System.out.println(cardnum +" "+ name +" " + cvv+" "+ pin+"/n");
					if(userCardNum == Long.parseLong(cardnum)){
						actualdetail.setCardNumber(userCardNum);
						actualdetail.setName(name);
						actualdetail.setExpMonth(Integer.parseInt(expm));
						actualdetail.setExpYear(Integer.parseInt(expy));
						actualdetail.setCvv(Integer.parseInt(cvv));
						actualdetail.setPin(Integer.parseInt(pin));
						 x = 1;
					}
			}
		}
		if( x == 0){
			actualdetail.setCardNumber(-1);
			actualdetail.setName(null);
			actualdetail.setExpMonth(-1);
			actualdetail.setExpYear(-1);
			actualdetail.setCvv(-1);
			actualdetail.setPin(-1);
		}
		reader.close();
		return actualdetail;
	}
}
