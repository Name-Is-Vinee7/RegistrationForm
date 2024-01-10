package in.vineeth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import in.vineeth.response.ResponseHandler;

@RestControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler  {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});

		return ResponseHandler.responseBuilder("bad credentials", HttpStatus.BAD_REQUEST, errorMap);
	}

	@ExceptionHandler(FormRegistrationNotFoundException.class)
	public ResponseEntity<ErMessage> FormRegistrationNotFoundException(FormRegistrationNotFoundException exception,
			WebRequest request) {

		ErMessage message = new ErMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
	}

}
