package com.aikiinc.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.domain.Message;
import com.aikiinc.util.LogRule;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsAppWithLogging {
	private static Logger LOG = LoggerFactory.getLogger(DroolsAppWithLogging.class);
	private static LogRule logRule;
	
	public static final void main(String[] args) {
		try {
			LOG.info("Config KIE");

			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");

			kSession.setGlobal("LOG", logRule);
			
			LOG.info("Fire all rules:");
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
