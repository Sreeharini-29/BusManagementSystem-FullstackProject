package BusManagementSystem.BusManagement1.exceptions;

public class ErrorResponse {
	private String message;
	private String errorId;

	public ErrorResponse() {

	}

	public ErrorResponse(String message, String errorId) {
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
