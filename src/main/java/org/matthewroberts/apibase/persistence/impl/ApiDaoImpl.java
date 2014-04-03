package org.matthewroberts.apibase.persistence.impl;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.matthewroberts.apibase.domain.ApiUser;
import org.matthewroberts.apibase.persistence.ApiDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * The implementation of the ApiDao interface. This class should connect to a
 * data store or external API to retrieve data. It currently assembles a default
 * object for demonstration purposes.
 * 
 * @author mroberts
 * 
 */
public class ApiDaoImpl extends JdbcDaoSupport implements ApiDao, Serializable {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Assembles a ApiUser object for demonstration purposes.
	 * 
	 * @param email the email address of the user to retrieve
	 * @return returns a constructed ApiUser object
	 */
	public ApiUser getApiUser(String email) {

		ApiUser apiUser = new ApiUser();

		if (email.equalsIgnoreCase("apiuser@test.com")) {
			apiUser.setEmail(email);
			apiUser.setUserName("apiuser1");
			apiUser.setId(3427238913498723489L);
		} else {
			apiUser.setError(true);
		}

		return apiUser;
	}

	public boolean processApiUser(String name, String email) {

		/* Logic to persist a new user */

		return true;
	}
}
