package com.aikiinc.app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aikiinc.domain.Message;
import com.aikiinc.util.LogRule;


public class DroolsAppWithLoggingTest {
	private static Logger LOG = LoggerFactory.getLogger(DroolsAppWithLogging.class);
	private static KieServices ks;
	private static KieContainer kContainer;
	private static KieSession kSession;
	private static LogRule logRule;
	
	@BeforeClass
	public static void beforeClass() {
		LOG.info("BeforeClass() Config KIE");

		// load up the knowledge base
		ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
		kSession = kContainer.newKieSession("ksession-rules");
	}

	@Test
	public void runDroolWithTest() {
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
