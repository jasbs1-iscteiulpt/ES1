package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import antiSpamFilter.RuleScanner;

public class TestRuleScanner {

	@Test
	public void test() {
		assertNotNull(RuleScanner.readFile("rulesNotNull.cf"));
		String[][] test = RuleScanner.MapToArray(RuleScanner.readFile("rulesNotNull.cf"));
		RuleScanner.writeFile("rulesNotNull.cf", test);
		assertArrayEquals(test,RuleScanner.MapToArray(RuleScanner.readFile("rulesNotNull.cf")));
	}
	
	@Test
	public void resultTest() {
		assertNotNull(RuleScanner.resultReader());
		String[] index=RuleScanner.resultReader();
		assertNotEquals(RuleScanner.readFile("rules.cf"),RuleScanner.resultConfig(RuleScanner.readFile("rules.cf") , Integer.parseInt(index[2])));
	}
	
}
