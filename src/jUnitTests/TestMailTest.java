package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import antiSpamFilter.MailTest;
import antiSpamFilter.RuleScanner;

public class TestMailTest {
	
	@Test
	public void test(){
		MailTest test = new MailTest(RuleScanner.readFile("RulesNotNull.cf"));
		assertEquals(1,test.getFN());
		assertEquals(1,test.getFP());
	}

}
