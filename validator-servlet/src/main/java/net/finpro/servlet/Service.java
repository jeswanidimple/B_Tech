package net.finpro.servlet;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Service extends Thread {
	  private final String name, cardnum, amount, city, year;
	  private final long time;
	  
	 //   private final int timeToStart;
	    private CyclicBarrier barrier;
	    private ServerClass serverClass = new ServerClass();
	  
	    public Service(String name, CyclicBarrier barrier, String c, String a, String city, String y, long t){
	        this.name = name;
	      //  this.timeToStart = timeToStart;
	        this.barrier = barrier;
	        this.cardnum = c;
	        this.amount = a;
	        this.city = city;
	        this.year = y;
	        this.time = t;
	    }
	  
	    @Override
	    public void run() {
	        try {
	            Thread.sleep(1000);
	            //System.out.println( name + " is Up");
				barrier.await();
	            int FRate = serverClass.fetchdetails(Long.parseLong(cardnum),city,Integer.parseInt(amount),Integer.parseInt(year),time);
				// System.out.println("Fraud rate for Thread " + name + " is " +FRate);
				 System.out.printf("%-9s %-9s %-12s %-9s %d\n", cardnum, amount, city, year, FRate);
		      } catch (InterruptedException | BrokenBarrierException e) {
		    	  e.printStackTrace();
		    	  //  Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	        
	    }
	  
	}
