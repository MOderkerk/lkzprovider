/**
 * 
 */
package de.oderkerk.tools.lkz.entity.rest;

import java.sql.Timestamp;
import java.time.Instant;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import de.oderkerk.tools.lkz.entity.rest.responses.ErrorResponse;
import de.oderkerk.tools.lkz.exception.NoDataFoundException;
import de.oderkerk.tools.lkz.rest.logging.Slf4jMDCFilterConfiguration;

/**
 * Controller-Advice for Handling all thrown exceptions
 * 
 * @author Odin
 * @version 11-2020
 *
 */
@RestControllerAdvice
public class RestControllerErrorHandler {

	@ExceptionHandler(NoDataFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponse handleNoDataFoundException(NoDataFoundException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorNo(100001);
		errorResponse.setErrorText(" " + ex.getMessage() + " not found");
		errorResponse.setErrorTimestamp(Timestamp.from(Instant.now()).toString());
		errorResponse.setUniqueID(getUUID());
		return errorResponse;
	}

	private String getUUID() {

		return MDC.get(Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY);
	}
}
