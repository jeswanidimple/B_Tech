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
		public int RunDrools(TransactionDetails userinfo) {
			int FRate = 0;
			try {
				KieServices ks = KieServices.Factory.get();
				KieFileSystem kfs = ks.newKieFileSystem();
				KieRepository kr = ks.getRepository();
				
				AccountDetails actualdetail = new ReadFile().ReadCsv(userinfo.getCardNum());
		//		kfs.write(ResourceFactory.newClassPathResource("rules/rule-city.drl", this.getClass()));
		//		kfs.write(ResourceFactory.newClassPathResource("rules/rule-year.drl", this.getClass()));
				kfs.write(ResourceFactory.newClassPathResource("rules/card-validity.drl", this.getClass()));
			//	kfs.write(ResourceFactory.newClassPathResource("rules/rule-time.drl", this.getClass()));
			//	kfs.write(ResourceFactory.newClassPathResource("rules/rule-diff.drl", this.getClass()));
				
				KieBuilder kb = ks.newKieBuilder(kfs);
	    		kb.buildAll();
	    		KieContainer kContainer = ks.getKieClasspathContainer();
	    		KieSession kSession = kContainer.newKieSession("ksession-rules");
	    		
	        	kSession.insert(userinfo);
	        	kSession.insert(actualdetail);

	        	kSession.fireAllRules();
				
		         FRate =  userinfo.getFScore();
			}
			catch (Throwable t) {
	            t.printStackTrace();
	        }
			return FRate;
		}
}

