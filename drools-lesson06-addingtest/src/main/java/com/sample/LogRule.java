package com.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogRule {
	private static Logger LOG = LoggerFactory.getLogger(LogRule.class);

	public static void info(String rulename, String msg) {
		LOG.info("Rule(" + rulename + "): " + msg);
	}

	public static void debug(String rulename, String msg) {
		LOG.debug("Rule(" + rulename + "): " + msg);
	}

}
