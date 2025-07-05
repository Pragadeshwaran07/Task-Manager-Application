package com.jap.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticatorTest {

	private Authenticator authenticator;

	@Before
	public void setUp() throws Exception {
		authenticator = new Authenticator();
	}

	@After
	public void tearDown() throws Exception {
		authenticator = null;
	}

	@Test
	public void checkIfAuthenticatedUserReturnsTrueOnLoginSuccess() {
		assertTrue(authenticator.authenticateUser("John", "pass1"));
	}


	@Test
	public void getAuthenticateduserForCorrectUserNameAndPassword() {
		authenticator.authenticateUser("John", "pass1");
		assertNotNull(authenticator.getAuthenticatedUser());
	}

}
