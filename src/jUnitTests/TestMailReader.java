package jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import antiSpamFilter.MailReader;

class TestMailReader {

	@Test
	void test() {
		assertNotNull(MailReader.read("rulesNotNull.cf"));
		assertNotNull(MailReader.read("rulesNull.cf"));
		assertNotEquals(MailReader.read("rulesNotNull.cf"), MailReader.read("rulesNull.cf"));
	}

}
