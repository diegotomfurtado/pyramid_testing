package com.diegotomfurtado.unittest.test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diegotomfurtado.unittest.builders.EmailAccountBuilder;
import com.diegotomfurtado.unittest.service.EmailAccount;
import com.diegotomfurtado.unittest.service.EmailClient;

/*
 * @author Diego Furtado
 * */
public class EmailAccountTest {

	EmailAccount _emailAccount;
	EmailAccountBuilder _emailAccountBuilder;
	Instant _instantNow;
	EmailClient _emailClient;

	private static final int DAYS_89 = -89;
	private static final int DAYS_90 = -90;
	private static final int DAYS_91 = -91;

	@Before
	public void setUp() {
		_instantNow = Instant.now();
		_emailAccountBuilder = new EmailAccountBuilder();
		_emailClient = new EmailClient();
	}

	@Test
	public void isPasswordExpiration_89days_False() {

		Instant instant89DaysAgo = _instantNow.plus(DAYS_89, ChronoUnit.DAYS);

		_emailAccount = _emailAccountBuilder.setLastPasswordUpdate(instant89DaysAgo).build();
		Assert.assertFalse(_emailAccount.verifyPasswordExpiration());
	}

	@Test
	public void isPasswordExpiration_after90days_False() {

		Instant instant90DaysAgo = _instantNow.plus(DAYS_90, ChronoUnit.DAYS);

		_emailAccount = _emailAccountBuilder.setLastPasswordUpdate(instant90DaysAgo).build();
		Assert.assertFalse(_emailAccount.verifyPasswordExpiration());
	}

	@Test
	public void isPasswordExpiration_after91days_True() {

		Instant instant91DaysAgo = _instantNow.plus(DAYS_91, ChronoUnit.DAYS);

		_emailAccount = _emailAccountBuilder.setLastPasswordUpdate(instant91DaysAgo).build();
		Assert.assertTrue(_emailAccount.verifyPasswordExpiration());
	}

}
