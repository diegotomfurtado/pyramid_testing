package com.diegotomfurtado.unittest.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/*
 * @author Diego Furtado
 * */
public class EmailAccount {

	private String _user;
	private String _domain;
	private String _password;
	private Instant _lastPasswordUpdate;

	private static final int DAYS_91 = 91;

	public EmailAccount(String user, String domain, String password, Instant lastPasswordUpdate) {
		super();
		this._user = user;
		this._domain = domain;
		this._password = password;
		this._lastPasswordUpdate = lastPasswordUpdate;
	}

	public void setLastPasswordUpdate(Instant lastPasswordUpdate) {

		this._lastPasswordUpdate = lastPasswordUpdate;
	}

	public void setUser(String user) {

		this._user = user;
	}

	public void setDomain(String domain) {

		this._domain = domain;
	}

	public void setPassword(String password) {

		this._password = password;
	}

	public boolean checkIfAUserIsAbleToUse() {

		return _user.matches("[(.)|(\\-)|(_)0-9a-zA-Z]+");
	}

	public boolean checkIdADomainIsAbleToUse() {

		return _domain.matches("\\b((?=[a-z0-9-]{1,}\\.)[a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}\\b");
	}

	public int getPasswordLength(EmailAccount account) {

		return account._password.length();
	}

	public boolean validUserAndDomain(EmailAccount account) {

		if (account.checkIfAUserIsAbleToUse() && account.checkIdADomainIsAbleToUse()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyPasswordExpiration() {

		Instant instantNow = Instant.now();
		Instant instant89DaysAgo = instantNow.plus(-DAYS_91, ChronoUnit.DAYS);

		return instant89DaysAgo.isAfter(_lastPasswordUpdate);
	}

}
