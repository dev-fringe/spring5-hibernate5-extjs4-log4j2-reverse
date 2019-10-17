package support;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import exception.GeneralMessageException;
import hibernate.model.ErrorResponse;

@RestControllerAdvice
public class RestControllerExceptionHandler {
	private static final Logger logger = LogManager.getLogger(RestControllerExceptionHandler.class.getName());

	@ExceptionHandler(value = { IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(Exception ex) {
		if (logger.isErrorEnabled()) {
			logger.error("badRequest(Exception) - ex={}", ex); //$NON-NLS-1$
		}
		return new ErrorResponse(400, "");
	}

	
//	@ExceptionHandler(value = { BusinessException.class })
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	public ErrorResponse businessRequest(BusinessException ex) {
//		if (logger.isErrorEnabled()) {
//			logger.error("badRequest(Exception) - ex={}", ex); //$NON-NLS-1$
//		}
//		return new ErrorResponse(400, ex.toString());
//	}

	
	@ExceptionHandler(value = { RuntimeException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(RuntimeException ex) {
		if (logger.isErrorEnabled()) {
			logger.error("RuntimeException(Exception) - ex={}", ex); //$NON-NLS-1$
		}
		return new ErrorResponse(400, "");
	}
	
	@ExceptionHandler(value = { SQLException.class, UncategorizedSQLException.class, BadSqlGrammarException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse sqlExpcetion(Exception ex) {
		if (logger.isErrorEnabled()) {
			logger.error("sqlExpcetion(Exception) - ex={}", ex); //$NON-NLS-1$
		}
		return new ErrorResponse(400, "");
	}



	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse unKnownException(Exception ex) {
		if (logger.isErrorEnabled()) {
			logger.error("unKnownException(Exception) - ex={}", ex); //$NON-NLS-1$
		}
		return new ErrorResponse(404,"");
	}
	
	@ExceptionHandler(value = { GeneralMessageException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse generalMessageException(GeneralMessageException ex) {
		if (logger.isErrorEnabled()) {
			logger.error("generalMessageException(Exception) - ex={}", ex); //$NON-NLS-1$
		}
		return new ErrorResponse(400, ex.toString().replaceAll(GeneralMessageException.class.getPackage().getName()+".", ""));
	}
}