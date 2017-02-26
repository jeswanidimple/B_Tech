package com.sample;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

public class ApplyDrools {

		public ApplyDrools() {
		}
		
		//public static final void main(String[] args) {
		public int RunDrools(TransactionDetails userinfo) {
			int FRate = 0;
			try {
//				System.out.println("Loading knowledge base");
				
				KieServices ks = KieServices.Factory.get();
				KieFileSystem kfs = ks.newKieFileSystem();
				KieRepository kr = ks.getRepository();
				
			//System.out.println("Calling .drl");
				kfs.write(ResourceFactory.newClassPathResource("rules/rule-city.drl", this.getClass()));
				kfs.write(ResourceFactory.newClassPathResource("rules/rule-year.drl", this.getClass()));
				kfs.write(ResourceFactory.newClassPathResource("rules/rule-card.drl", this.getClass()));
				kfs.write(ResourceFactory.newClassPathResource("rules/rule-time.drl", this.getClass()));
				kfs.write(ResourceFactory.newClassPathResource("rules/rule-diff.drl", this.getClass()));

				//kfs.write(ResourceFactory.newClassPathResource("rules/rule-card.drl", this.getClass()));
				
				KieBuilder kb = ks.newKieBuilder(kfs);
	    		kb.buildAll();
	    		KieContainer kContainer = ks.getKieClasspathContainer();
	   // 		KieContainer kContainer = ks.newKieContainer(kr.getDefaultReleaseId());
	    		KieSession kSession = kContainer.newKieSession("ksession-rules");
	    		
	    	//	System.out.println("Inserting");
	        	kSession.insert(userinfo);
	        //	System.out.println("Inserted");
				
	        //	System.out.println("Firing Rules");			
	        	kSession.fireAllRules();
		      //  System.out.println("All Rules Fired");
				
		         FRate =  userinfo.getFScore();
		        
			}
			catch (Throwable t) {
	            t.printStackTrace();
	        }
			return FRate;
		}
}

