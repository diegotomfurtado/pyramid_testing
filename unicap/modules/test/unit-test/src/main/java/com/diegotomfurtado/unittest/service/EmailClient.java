package com.diegotomfurtado.unittest.service;

import java.util.Collection;

import com.diegotomfurtado.unittest.entity.Email;
import com.diegotomfurtado.unittest.interfac.EmailService;

/*
 * @author Diego Furtado
 * */
public class EmailClient extends Email implements EmailService {

	Collection<EmailAccount> _accounts;
	EmailService _emailService;
	Email _email;
	EmailAccount _emailAccount = new EmailAccount(null, null, null, null);

	public boolean isValidAddress(String emailAddress) {

		boolean returnAdressInformation = false;
		String[] returnFromValidAdress = emailAddress.split("@");

		EmailAccount emailAccountToValid = new EmailAccount(returnFromValidAdress[0], returnFromValidAdress[1], null,
				null);
		if (emailAccountToValid.checkIfAUserIsAbleToUse() && emailAccountToValid.checkIdADomainIsAbleToUse()) {

			return returnAdressInformation = true;
		}
		return returnAdressInformation;
	}

	public boolean isValidEmail(Email email) {

		boolean validCreationDate = validateCreationDate(email);
		boolean validFrom = validateFromMail(email);
		boolean validToMail = validateToMails(email);
		boolean validBccMail = validateBccMails(email);
		boolean validCcMail = validateCcMails(email);

		return validCreationDate && validFrom && validToMail && validBccMail && validCcMail;
	}

	private boolean validateCreationDate(Email email) {
		return email.getCreationDate() != null;
	}

	private boolean validateFromMail(Email email) {
		return isValidAddress(email.getFrom());
	}

	private boolean validateToMails(Email email) {

		boolean validTos = false;
		for (String toMailAdress : email.getTo()) {
			validTos = validTos || isValidAddress(toMailAdress);
		}

		return validTos;
	}

	private boolean validateCcMails(Email email) {

		boolean validCcs = false;
		for (String ccMailAdress : email.getCc()) {
			validCcs = validCcs || isValidAddress(ccMailAdress);
		}
		return validCcs;
	}

	private boolean validateBccMails(Email email) {

		boolean validBccs = false;
		for (String bccMailAdress : email.getBcc()) {
			validBccs = validBccs || isValidAddress(bccMailAdress);
		}
		return validBccs;
	}

	@Override
	public boolean sendEmail(Email email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Email> emailList(EmailAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

}
