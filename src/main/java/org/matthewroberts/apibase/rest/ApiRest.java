package org.matthewroberts.apibase.rest;

import java.util.NoSuchElementException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.matthewroberts.apibase.domain.ApiUser;
import org.matthewroberts.apibase.service.ApiManager;

/**
 * Jersey implementation that exposes API end points. 
 * 
 * @author mroberts
 * 
 */
@Path("/api")
public class ApiRest {

	private ApiManager apiManager;
	protected final Log logger = LogFactory.getLog(getClass());

	public void setApiManager(ApiManager apiManager) {
		this.apiManager = apiManager;
	}

	/**
	 * Handles GET requests at /api?email= returning a JSON formatted String.
	 * 
	 * @param email
	 *            the email address of the user to retrieve
	 * @return if user is found, returns a JSON formatted String of the user
	 *         record requested, else if user is not found, returns a 404, else
	 *         if email address if improperly specified, returns a 400
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON + ";charset=utf-8" })
	public Response getContact(@QueryParam("email") String email) {

		ApiUser apiUser = null;
		Response response = null;

		if (email.isEmpty() || email == null) {
			response = Response.status(Response.Status.BAD_REQUEST)
					.entity("Bad request - email address not specified")
					.build();
		} else {
			try {
				apiUser = this.apiManager.getApiUser(email);
			} catch (NoSuchElementException e) {
				logger.info("GET Response: API user not found - EMAIL:" + email);
				e.printStackTrace();
			}

			if (apiUser.isError()) {
				logger.info("GET Response: API user not found - EMAIL:" + email);
				response = Response.status(Response.Status.NOT_FOUND)
						.entity("API user not found").build();
			} else {
				logger.info("GET Response: API user " + email + " returned");
				response = Response.status(Response.Status.OK).entity(apiUser)
						.build();
			}
		}

		return response;
	}
}