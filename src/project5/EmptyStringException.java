package project5;

/**
 * This class is a subclass of Exception. It helps deal with exception thrown when
 * users do not enter any input before pressing enter.
 * 
 * @author PC
 *
 */
public class EmptyStringException extends Exception {
	public String getMessage() {
		return "Invalid (empty) string!";
	}
}
