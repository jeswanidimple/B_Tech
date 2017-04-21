package net.finpro.servlet;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Service extends Thread {
	  private final String cardnum, amount, city, year, month, pin, cardname;
	  private final long time;
	
	  
	 //   private final int timeToStart;
	    private CyclicBarrier barrier;
	    private ServerClass serverClass = new ServerClass();
	  
	    public Service(CyclicBarrier barrier, String c, String a, String city, String y, long t, String cardname, String pin, String m){
	        this.barrier = barrier;
	        this.cardnum = c;
	        this.amount = a;
	        this.city = city;
	        this.year = y;
	        this.time = t;
	        this.month = m;
	        this.pin = pin;
	        this.cardname = cardname;
	    }
	  
	    @Override
	    public void run() {
	        try {
	        	//System.out.println("thread going to sleep");
	            Thread.sleep(500);
	          //  System.out.println("thread slept");
				barrier.await();
				//System.out.println("hiiiiiiiiiiiiiiiiiiiii");
				int FRate = serverClass.fetchdetails(Long.parseLong(cardnum),city,Integer.parseInt(amount),Integer.parseInt(year),time,cardname,Integer.parseInt(pin),Integer.parseInt(month));
				// System.out.println("Fraud rate for Thread " + cardname + " is " +FRate);
				 System.out.printf("%-9s %-40s %-9s %-12s %-9s %d\n", cardnum, cardname, amount, city, year, FRate);
		      } catch (InterruptedException | BrokenBarrierException e) {
		    	  e.printStackTrace();
		    	  //  Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	    }
	  
	}
