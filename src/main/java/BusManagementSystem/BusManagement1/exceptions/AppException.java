package BusManagementSystem.BusManagement1.exceptions;

public class AppException extends RuntimeException {
	private String message;
	private String errorId;

	public AppException(String message, String errorId) {
		super(message);
		this.message = message;
		this.errorId = errorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
}
