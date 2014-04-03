package org.matthewroberts.apibase.service;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRegistry;

import org.matthewroberts.apibase.domain.ApiUser;

/**
 * Interface defining methods for the API manager.
 * 
 * @author mroberts
 * 
 */
@XmlRegistry
public interface ApiManager extends Serializable {

	public boolean processApiUser(String name, String email);

	public ApiUser getApiUser(String email);
}
