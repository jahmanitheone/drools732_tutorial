package com.aikiinc.app;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DroolsAppWithLoggingTest {
	private static Logger LOG = LoggerFactory.getLogger(DroolsAppWithLoggingTest.class);
	private static DroolsAppWithLogging droolsAppWithLogging;

	@BeforeClass
	public static void beforeClass() {
		LOG.info("BeforeClass() Config KIE");
		droolsAppWithLogging = new DroolsAppWithLogging();
	}

	@Test
	public void runDrool() {
		try {
			LOG.info("runDroolWithTest");

			droolsAppWithLogging.run();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
