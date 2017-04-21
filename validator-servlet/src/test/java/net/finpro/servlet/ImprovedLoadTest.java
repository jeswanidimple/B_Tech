/*package net.finpro.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ImprovedLoadTest {
	 private ServerClass serverClass = new ServerClass();
	 private ExecutorService executor = Executors.newCachedThreadPool();
	public static void main(String[] args) throws IOException {
		ImprovedLoadTest loadTest = new ImprovedLoadTest();
		loadTest.run();
	}

	private void run() throws IOException {
		AtomicInteger index = new AtomicInteger();
		index.set(0);
		Files.lines(Paths.get("src/test/resources/sample.csv")).parallel().forEach(e -> {
			String[] parts = e.split(",");
			String cardnum = parts[0];
			String amount = parts[1];
			String city = parts[2];
			String year = parts[3];
			executor.submit(new Runnable() {
				private int count = index.incrementAndGet();
				@Override
				public void run() {
					int fRate = serverClass.fetchdetails(Long.parseLong(cardnum), city, Integer.parseInt(amount),Integer.parseInt(year), System.currentTimeMillis());
					System.out.println("Fraud rate for Thread " + count+ " is " +fRate);
					
				}
			});
		});

	}

}
*/