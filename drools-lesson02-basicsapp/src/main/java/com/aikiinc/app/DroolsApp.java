package com.aikiinc.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.aikiinc.domain.Message;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsApp {

    public static final void main(String[] args) {
        try {
        	System.out.println("Config KIE");
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	System.out.println("Fire all rules:");
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
