package com.diegotomfurtado.unittest.test;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.diegotomfurtado.unittest.entity.Email;
import com.diegotomfurtado.unittest.service.EmailClient;

/*
 * @author Diego Furtado
 * */
public class EmailIsValidAdressTest {

	private EmailClient _emailClient;
	private Email _email;

	@Before
	public void setup() {

		List<String> targetEmails = Arrays.asList("habemus@email.com", "mamute@email.com");

		_email = new Email();
		_email.setCreationDate(Instant.now());
		_email.setBcc(targetEmails);
		_email.setCc(targetEmails);
		_email.setTo(targetEmails);
		_email.setFrom("diego.furtado@gmail.com");
		_email.setMessage("Hello, its me!");
		_email.setSubject("Nothing to declare!");

		_emailClient = new EmailClient();

	}

	@Test
	public void isValidUserAddress_containsDot_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress(".diego.furtado.@gmail.com"));
	}

	@Test
	public void isValidUserAddress_containsUnderline_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress("_diego_furtado_@gmail.com"));
	}

	@Test
	public void isValidUserAdress_containsTrace_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress("-diego-furtado-@gmail.com"));
	}

	@Test
	public void isValidUserAddress_containsMixCharacters_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress("-diego.furtado_@gmail.com"));
	}

	@Test
	public void isValidUserAddress_containsAlphanumericsNumbersSpecialCharacters_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress("-12diego.furtado32_@gmail.com"));
	}

	@Test
	public void isValidUserAddress_withoutUser_False() {

		_emailClient = new EmailClient();
		Assert.assertFalse(_emailClient.isValidAddress("@gmail.com"));
	}

	@Test
	public void isvalidDomain_dobleSequenceDot_False() {

		_emailClient = new EmailClient();
		Assert.assertFalse(_emailClient.isValidAddress("diego_furtado@gmail..com"));
	}

	@Test
	public void isValidDomain_dobleDotWithouSequence_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress("diego_furtado@gmail.com.br"));
	}

	@Test
	public void isvalidDomain_numbersAndDotAndLetters_True() {

		_emailClient = new EmailClient();
		Assert.assertTrue(_emailClient.isValidAddress("diego_furtado@gmail2.com.br"));
	}

	@Test
	public void isValidEmail_CreationDate_True() {

		_email.setCreationDate(Instant.now());
		Assert.assertTrue(_emailClient.isValidEmail(_email));
	}

	@Test
	public void isValidEmail_CreationEmptyDate_False() {

		_email.setCreationDate(null);
		Assert.assertFalse(_emailClient.isValidEmail(_email));
	}

	@Test
	public void isValidEmail_InvalidListToAddress_True() {

		List<String> targetInvalidEmails = Arrays.asList("habemus-@email.com", "mamu$te@email.com",
				"email.ok@email.com");

		_email.setTo(targetInvalidEmails);
		Assert.assertTrue(_emailClient.isValidEmail(_email));
	}

	@Test
	public void isValidEmail_InvalidFromAddress_False() {

		_email.setFrom("des$c*onhecido@nada.com");
		Assert.assertFalse(_emailClient.isValidEmail(_email));
	}

	@Test
	public void isValidEmail_True() {

		Assert.assertTrue(_emailClient.isValidEmail(_email));
	}
}
