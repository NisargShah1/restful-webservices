package com.webservicedemo.exception;

/**
 * @author NISARG
 *
 */
public class RestWSException extends Exception{
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	private String errorCode;	
	private String customMsg;
	private String wrappedException;

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the customMsg
	 */
	public String getCustomMsg() {
		return customMsg;
	}

	/**
	 * @param customMsg the customMsg to set
	 */
	public void setCustomMsg(String customMsg) {
		this.customMsg = customMsg;
	}

	/**
	 * @return the wrappedException
	 */
	public String getWrappedException() {
		return wrappedException;
	}

	/**
	 * @param wrappedException the wrappedException to set
	 */
	public void setWrappedException(String wrappedException) {
		this.wrappedException = wrappedException;
	}

	/**
	 * 
	 */
	public RestWSException() {
	}
	
	/**
	 * @param errorCode
	 * @param customMsg
	 */
	public RestWSException(String errorCode, String customMsg) {
		this.errorCode = errorCode;
		this.customMsg = customMsg;
	}

	/**
	 * This constructor is needed for wrap and throw scenario
	 * specially when 
	 * @param customMsg
	 * @param t
	 */
	public RestWSException(String errorCode, String customMsg, Throwable throwable) {
		super(customMsg, throwable);
		this.errorCode = errorCode;
		this.customMsg = customMsg;
		this.wrappedException = throwable.toString();
	}
	
	/**
	 * @param customMsg
	 */
	public RestWSException(String customMsg){
		super(customMsg);
		this.customMsg = customMsg;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestWSException [errorCode=" + errorCode + ", customMsg="
				+ customMsg + ", wrappedException=" + wrappedException + "]";
	}
}
