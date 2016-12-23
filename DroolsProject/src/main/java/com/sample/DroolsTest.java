package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.internal.io.ResourceFactory;


//import java.util.Scanner;
//import java.io.PrintStream;
//import java.nio.file.*;
/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public DroolsTest() {
	}
	
	public void RunDrools(TransactionDetails userinfo) {
		try {
			System.out.println("DroolsTest.java called");
			
			System.out.println("Loading knowledge base");
			KieServices ks = KieServices.Factory.get();
			KieRepository kr = ks.getRepository();
			KieFileSystem kfs = ks.newKieFileSystem();
			
	        System.out.println("calling .drl file");
			kfs.write(ResourceFactory.newClassPathResource("rules/rule-city.drl", this.getClass()));
			KieBuilder kb = ks.newKieBuilder(kfs);
			kb.buildAll();
						
			KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
			KieSession kSession = kContainer.newKieSession();
			
			System.out.println("Inserting into session");
			kSession.insert(userinfo);
			
			System.out.println("Firing Rules");
			kSession.fireAllRules();
			System.out.println("All Rules Fired");
			
		}
		catch (Throwable t) {
            t.printStackTrace();
        }
	}
}
/*
    public void ApplyRule(TransactionDetails userdetail) {
        try {
        	System.out.println("DroolsTest.java called");
            // load up the knowledge base
        	System.out.println("Loading up the knowledge base");
	        KieServices ks = KieServices.Factory.get();
	        KieRepository kr = ks.getRepository();
	        KieContainer kContainer = ks.getKieClasspathContainer();
	        KieFileSystem kfs = ks.newKieFileSystem();
	        
cc
     		String contents = new String(Files.readAllBytes(Paths.get("rule-city.drl")));
	        kfs.write("src/main/resources/rules/rule-city.drl",contents);
	        
	        System.out.println(contents);
	        
	        KieBuilder kb = ks.newKieBuilder(kfs);
	        kb.buildAll();

	        if (kb.getResults().hasMessages(Level.ERROR)) {
	            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
	        }

	        KieSession kSession = kContainer.newKieSession();
	        
	        kSession.insert(userdetail);
	        kSession.fireAllRules();

        	// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.insert(userdetail);
            kSession.fireAllRules();            
          
        	System.out.println("Rules Fired");
         } 
        
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
}
*/