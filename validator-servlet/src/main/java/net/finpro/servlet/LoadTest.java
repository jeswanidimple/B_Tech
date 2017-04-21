package net.finpro.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class LoadTest {
	
	public static void main(String[] args) throws IOException {
		
		InputStream in = LoadTest.class.getClassLoader().getResourceAsStream("sample.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		CyclicBarrier barrier = new CyclicBarrier(98);
		
		String line = null;
		Scanner scanner = null;
		int index = 1;
		  Date date = new Date();
		  long time = date.getTime();
		
		  while (index <= 98) {
			line = reader.readLine();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String cardnum = scanner.next();
				String name = scanner.next();
				String month = scanner.next();
				String year = scanner.next();
				String pin = scanner.next();
				String amount = scanner.next();
				String city = scanner.next();
		
		//	System.out.println("\n" + cardnum+" " + name + " "+ city + " "+ year);
				Thread thread = new Thread(new Service( barrier,cardnum,amount, city, year, time,name, pin, month));
				//System.out.println("thread statring");
				thread.start();
			//	System.out.println("thread started");
				index++;
			}
		}
		reader.close();
		System.out.println("index  "+ index);
	}
}