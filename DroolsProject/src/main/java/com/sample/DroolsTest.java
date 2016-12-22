package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message.Level;
//import org.kie.internal.io.*;
//import java.util.Scanner;
//import java.io.PrintStream;
import java.nio.file.*;
/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public void ApplyRule(TransactionDetails userdetail) {
        try {
/*            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
	        KieRepository kr = ks.getRepository();
	        KieFileSystem kfs = ks.newKieFileSystem();
	        
     		String contents = new String(Files.readAllBytes(Paths.get("rule-city.drl")));
	        kfs.write("src/main/resources/rules/rule-city.drl",contents);
	        
	        System.out.println(contents);
	        
	        KieBuilder kb = ks.newKieBuilder(kfs);
	        kb.buildAll();

	        if (kb.getResults().hasMessages(Level.ERROR)) {
	            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
	        }

	        KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());

	        KieSession kSession = kContainer.newKieSession();
	        
	        kSession.insert(userdetail);
	        kSession.fireAllRules();
*/
        	// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            kSession.insert(userdetail);
            kSession.fireAllRules();
         } 
        
        catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
}
