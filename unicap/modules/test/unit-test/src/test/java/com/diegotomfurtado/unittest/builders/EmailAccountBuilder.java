package com.diegotomfurtado.unittest.builders;

import java.time.Instant;

import com.diegotomfurtado.unittest.service.EmailAccount;

/*
 * @author Diego Furtado
 * */
public class EmailAccountBuilder {

	private String _user = "Diego.Furtado";
	private String _domain = "gmail.com";
	private String _password = null;
	private Instant _lastPasswordUpdate = Instant.now();

	public EmailAccountBuilder setUser(String user) {
		this._user = user;
		return this;
	}

	public EmailAccountBuilder setDomain(String domain) {
		this._domain = domain;
		return this;
	}

	public EmailAccountBuilder setPassword(String password) {
		this._password = password;
		return this;
	}

	public EmailAccountBuilder setLastPasswordUpdate(Instant lastPasswordUpdate) {
		this._lastPasswordUpdate = lastPasswordUpdate;
		return this;
	}

	public EmailAccount build() {
		EmailAccount emailAccount = new EmailAccount(null, null, null, null);
		emailAccount.setUser(this._user);
		emailAccount.setDomain(this._domain);
		emailAccount.setPassword(this._password);
		emailAccount.setLastPasswordUpdate(this._lastPasswordUpdate);
		return emailAccount;
	}
}