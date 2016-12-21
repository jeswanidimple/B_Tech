package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            TransactionDetails detail1 = new TransactionDetails();
            detail1.setCardNumber(1010);
            detail1.setCity("Mumbnai");
            detail1.setAmount(7000);
            kSession.insert(detail1);
            
            TransactionDetails detail2 = new TransactionDetails();
            detail2.setCardNumber(2020);
            detail2.setCity("pUNe");
            detail2.setAmount(4000);
            kSession.insert(detail2);
            
            kSession.fireAllRules();
        
            System.out.println(detail1.getCity().toString() + " " + detail1.getMaxLimit());
            System.out.println(detail2.getCity().toString() + " " + detail2.getMaxLimit());
        } 
        
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
