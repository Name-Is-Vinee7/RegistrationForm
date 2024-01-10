package in.vineeth;

@SuppressWarnings("serial")
public class FormRegistrationNotFoundException extends Exception{

	public FormRegistrationNotFoundException() {
		super();
	}

	public FormRegistrationNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormRegistrationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormRegistrationNotFoundException(String message) {
		super(message);
	}

	public FormRegistrationNotFoundException(Throwable cause) {
		super(cause);
	}

}
