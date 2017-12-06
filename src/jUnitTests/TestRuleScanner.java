package jUnitTests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import antiSpamFilter.RuleScanner;

class TestRuleScanner {

	@Test
	void test() {
		assertNotNull(RuleScanner.readFile("rulesNotNull.cf"));
		String[][] test = RuleScanner.MapToArray(RuleScanner.readFile("rulesNotNull.cf"));
		RuleScanner.writeFile("rulesNotNull.cf", test);
		assertArrayEquals(test,RuleScanner.MapToArray(RuleScanner.readFile("rulesNotNull.cf")));
	}
	
}
