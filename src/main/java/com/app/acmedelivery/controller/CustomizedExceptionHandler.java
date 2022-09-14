package com.app.acmedelivery.controller;

import com.app.acmedelivery.base.BaseComponent;
import com.app.acmedelivery.transfer.ApiError;
import com.app.acmedelivery.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class CustomizedExceptionHandler extends BaseComponent {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> catchAllExceptions(Exception ex, WebRequest webRequest) {
		logger.error("Exception caught");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ApiResponse.<Void>builder().apiError(ApiError.builder().description("Something went wrong").httpStatus(
						HttpStatus.INTERNAL_SERVER_ERROR.value()).path(webRequest.getDescription(false)).build()).build());

	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiResponse<Void>> notFoundException(NoSuchElementException ex, WebRequest webRequest) {
		logger.error("NoSuchElementException Exception caught");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				ApiResponse.<Void>builder().apiError(ApiError.builder().description(ex.getMessage()).httpStatus(
						HttpStatus.NOT_FOUND.value()).path(webRequest.getDescription(false)).build()).build());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
																		  final WebRequest webRequest) {
		logger.error("Method argument is invalid.", ex);
		return new ResponseEntity<>(
				ApiResponse.builder().apiError(ApiError.builder().description(ex.getMessage().substring(480)).httpStatus(
						HttpStatus.NOT_FOUND.value()).path(webRequest.getDescription(false)).build()).build(),
				HttpStatus.BAD_REQUEST);
	}
}
