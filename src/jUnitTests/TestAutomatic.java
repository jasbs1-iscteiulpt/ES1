package jUnitTests;

import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import antiSpamFilter.RuleScanner;
import interfaceAndProblem.AntiSpamFilterAutomaticConfiguration;

class TestAutomatic {

	@Test
	void test() {
		try {
			AntiSpamFilterAutomaticConfiguration.SIMULATION=500;
			AntiSpamFilterAutomaticConfiguration.run("rulesforTest.cf");
			assertNotNull(RuleScanner.resultReader());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
