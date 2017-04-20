package net.finpro.servlet;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LoadTest {
	
	public static void main(String[] args) throws IOException {
		
		InputStream in = LoadTest.class.getClassLoader().getResourceAsStream("sample.csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		CyclicBarrier barrier = new CyclicBarrier(100);
		
		String line = null;
		Scanner scanner = null;
		
		int index = 1;
		  Date date = new Date();
		  long time = date.getTime();
		
		  while (index <= 100) {
			line = reader.readLine();
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				String cardnum = scanner.next();
				String amount = scanner.next();
				String city = scanner.next();
				String year = scanner.next();
			/*	htmlStr += "<tr><td>" + cardnum + "</td>";
				htmlStr += "<td>" + amount + "</td>";
				htmlStr += "<td>" + city + "</td>";
				htmlStr += "<td>" + year + "</td></tr>";
				System.out.println("\n" + cardnum+" " + amount + " "+ city + " "+ year);
*/			
				Thread thread = new Thread(new Service(String.valueOf(index), barrier,cardnum,amount, city, year, time));
				thread.start();
				index++;
			}
		}
		reader.close();
		
	}
}