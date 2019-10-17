package hibernate.model;

import lombok.Data;

@Data
public class ErrorResponse {
	private int status;
	private String message;

	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + "]";
	}

	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ErrorResponse() {
		super();
	}
}