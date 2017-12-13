package jUnitTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import antiSpamFilter.Interface;
import antiSpamFilter.StartMenuInterface;

public class TestInterface {
	
	@Test
	public void test() {
		assertNotNull(new StartMenuInterface());
		assertNotNull(new Interface());
	}

}
