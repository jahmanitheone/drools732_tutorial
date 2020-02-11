package com.sample;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.LogRule;
import com.sample.Message;

public class DroolsAppWithLoggingTest {
	private static KieServices ks;
	private static KieContainer kContainer;
	private static KieSession kSession;
	private static LogRule logRule;
	
	@BeforeClass
	public static void beforeClass() {
		// load up the knowledge base
		ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
		kSession = kContainer.newKieSession("ksession-rules");
	}

	@Test
	public void runDroolWithTest() {
		try {
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
