package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFile {

	AccountDetails ReadCsv(long userCardNum, int len) throws IOException{

		InputStream in = ReadFile.class.getClassLoader().getResourceAsStream("data.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String line = null;
		Scanner scanner = null;

		//long userCardNum = userinfo.getCardNum();   //entered by the user
		AccountDetails actualdetail = new AccountDetails();   //in our database
		int x = 0;
		int index = 0;
		while (index < 196) {
			line = reader.readLine();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");

			while (scanner.hasNext()) {
				String cardnum = scanner.next();
				String name = scanner.next();
				String expm = scanner.next();
				String expy = scanner.next();
				String cvv = scanner.next();
				String pin = scanner.next();
			//	System.out.println(cardnum +" "+ name +" " + cvv+" "+ pin+"/n");
				if(userCardNum == Long.parseLong(cardnum)){
					System.out.println(cardnum);
					actualdetail.setCardNumber(userCardNum);
					actualdetail.setName(name);
					actualdetail.setExpMonth(Integer.parseInt(expm));
					actualdetail.setExpYear(Integer.parseInt(expy));
					if ( len == 3)
						actualdetail.setPin(Integer.parseInt(cvv));
					if(len == 4 )
						actualdetail.setPin(Integer.parseInt(pin));
					x = 1;
				}
			}
			index++;
		}
		/*if( x == 0){
			actualdetail.setCardNumber(-1);
			actualdetail.setName(null);
			actualdetail.setExpMonth(-1);
			actualdetail.setExpYear(-1);
			actualdetail.setPin(-1);
		}*/
		reader.close();
		return actualdetail;
	}
}
