package org.nlc.exceptions;

/**
 * 
 * @author sandip.p.sangale
 *
 */
public class InvalidExpressionException extends RuntimeException {

	private static final long serialVersionUID = -9124924901235499L;

	public InvalidExpressionException(String message) {
		super(message);
	}
}
