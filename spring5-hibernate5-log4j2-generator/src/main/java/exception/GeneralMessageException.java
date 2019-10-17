package exception;

public class GeneralMessageException extends RuntimeException {

	private static final long serialVersionUID = -9081319836036084662L;

	public GeneralMessageException(String message) {
      super("Error Message : " + message);
  }

}
