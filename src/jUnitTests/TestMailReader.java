package jUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import antiSpamFilter.MailReader;

public class TestMailReader {

	@Test
	public void test() {
		assertNotNull(MailReader.read("rulesNotNull.cf"));
		assertNotNull(MailReader.read("rulesNull.cf"));
		assertNotEquals(MailReader.read("rulesNotNull.cf"), MailReader.read("rulesNull.cf"));
	}

}
