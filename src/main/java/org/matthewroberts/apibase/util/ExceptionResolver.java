package org.matthewroberts.apibase.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * Extends Spring's SimpleMapping ExceptionResolver in order to provide global
 * error handling for exceptions.
 * 
 * @author mroberts
 * 
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {

		logger.info(null, exception);
		return super.resolveException(request, response, handler, exception);
	}
}
