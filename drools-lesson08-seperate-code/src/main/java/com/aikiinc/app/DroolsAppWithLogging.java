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
	private KieServices ks;
	private KieContainer kContainer;
	private KieSession kSession;
	private LogRule logRule;
	
	public DroolsAppWithLogging() {
		try {
			LOG.info("DroolsAppWithLogging() Config KIE");

			// load up the knowledge base
			ks = KieServices.Factory.get();
			kContainer = ks.getKieClasspathContainer();
			kSession = kContainer.newKieSession("ksession-rules");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void run() {
		try {
			LOG.info("Fire all rules:");
			kSession.setGlobal("LOG", logRule);
			
			// go !
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
