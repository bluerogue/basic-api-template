package org.matthewroberts.apibase.persistence;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRegistry;

import org.matthewroberts.apibase.domain.ApiUser;

/**
 * Interface defining methods for API data access.
 * 
 * @author mroberts
 * 
 */
@XmlRegistry
public interface ApiDao extends Serializable {

	public boolean processApiUser(String name, String email);

	public ApiUser getApiUser(String email);
}
