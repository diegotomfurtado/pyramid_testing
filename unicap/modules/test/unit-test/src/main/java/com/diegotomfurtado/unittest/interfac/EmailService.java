package com.diegotomfurtado.unittest.interfac;

import java.util.Collection;

import com.diegotomfurtado.unittest.entity.Email;
import com.diegotomfurtado.unittest.service.EmailAccount;

/*
 * @author Diego Furtado
 * */
public interface EmailService {

	boolean sendEmail(Email email);

	Collection<Email> emailList(EmailAccount account);

}