package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public DroolsTest() {
	}
	
	//public static final void main(String[] args) {
	public void RunDrools(TransactionDetails userdetail) {
		try {
			
			System.out.println("Loading knowledge base");
			
			KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
      
        	//TransactionDetails userdetail = new TransactionDetails();
        	//userdetail.setCity("Poona");
        	kSession.insert(userdetail);
			
			System.out.println("Firing Rules");
			kSession.fireAllRules();
	        System.out.println("All Rules Fired");
			
		}
		catch (Throwable t) {
            t.printStackTrace();
        }
	}
}
