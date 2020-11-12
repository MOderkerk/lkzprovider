package de.oderkerk.tools.lkz.exception;

/**
 * Exception thrown when no data is found
 * @author Odin
 * @version 11-2020
 *
 */
public class NoDataFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1022002010211607678L;

	public NoDataFoundException(String message) {
		super("No data found for Input:"+message);
	}

}
