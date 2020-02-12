package com.aikiinc.app;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class KnowledgeSessionHelper {

	/**
	 * KieServer is factory for container. KieContainer provides access to stateful
	 * or stateless session
	 * 
	 * @return
	 */
	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kieContainer = ks.getKieClasspathContainer();
		return kieContainer;
	}

	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kieContainer, String sessionName) {
		StatelessKieSession kSession = kieContainer.newStatelessKieSession(sessionName);

		return kSession;
	}

	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {

		KieSession kSession = kieContainer.newKieSession(sessionName);

		return kSession;
	}

}
