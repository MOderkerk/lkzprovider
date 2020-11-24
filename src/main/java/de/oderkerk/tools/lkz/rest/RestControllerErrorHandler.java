/**
 * 
 */
package de.oderkerk.tools.lkz.rest;

import java.sql.Timestamp;
import java.time.Instant;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import de.oderkerk.tools.lkz.exception.NoDataFoundException;
import de.oderkerk.tools.lkz.rest.logging.Slf4jMDCFilterConfiguration;
import de.oderkerk.tools.lkz.rest.responses.ErrorResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller-Advice for Handling all thrown exceptions
 * 
 * @author Odin
 * @version 11-2020
 *
 */
@RestControllerAdvice
@Slf4j
public class RestControllerErrorHandler {

	@ExceptionHandler(NoDataFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorResponse handleNoDataFoundException(NoDataFoundException ex, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorNo(100001);
		errorResponse.setErrorText(" " + ex.getMessage() );
		errorResponse.setErrorTimestamp(Timestamp.from(Instant.now()).toString());
		errorResponse.setUniqueID(getUUID());
		log.error("Errorresponse {}",errorResponse.toString() );
		return errorResponse;
	}

	private String getUUID() {

		return MDC.get(Slf4jMDCFilterConfiguration.DEFAULT_MDC_UUID_TOKEN_KEY);
	}
}
