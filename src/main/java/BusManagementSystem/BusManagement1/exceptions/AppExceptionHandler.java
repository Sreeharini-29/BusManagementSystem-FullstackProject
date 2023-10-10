package BusManagementSystem.BusManagement1.exceptions;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(AppException.class)
	public ResponseEntity<ErrorResponse> appExceptionHandler(AppException appException) {
		ErrorResponse errorResponse = new ErrorResponse();
		BeanUtils.copyProperties(appException, errorResponse);
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);

	}

}
