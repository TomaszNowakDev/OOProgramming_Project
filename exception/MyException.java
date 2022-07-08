package exception;
import java.io.IOException;

// Exception handler class
@SuppressWarnings("serial")
public class MyException extends IOException {
	public MyException(String message) {
		super(message);
	}
}
