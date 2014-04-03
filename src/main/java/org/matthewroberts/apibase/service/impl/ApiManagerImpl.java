package org.matthewroberts.apibase.service.impl;

import java.io.Serializable;

import org.matthewroberts.apibase.domain.ApiUser;
import org.matthewroberts.apibase.persistence.ApiDao;
import org.matthewroberts.apibase.service.ApiManager;

/**
 * The implementation of the ApiManager interface. Logic such as processing,
 * utility functions, pre- and post-conditions testing, and so forth should be
 * handled here.
 * 
 * @author mroberts
 * 
 */
public class ApiManagerImpl implements ApiManager, Serializable {

	private static final long serialVersionUID = 1L;
	private ApiDao apiDao;

	public void setApiDao(ApiDao apiDao) {
		this.apiDao = apiDao;
	}

	public boolean processApiUser(String name, String email) {

		boolean isSaved = false;
		isSaved = apiDao.processApiUser(name, email);

		return isSaved;
	}

	public ApiUser getApiUser(String email) {

		ApiUser apiUser = new ApiUser();
		apiUser = apiDao.getApiUser(email);

		return apiUser;
	}
}
