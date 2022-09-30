package project5;
/**
 * This class is a subclass of Exception. It helps deal with exception thrown when
 * users enter an invalid input.
 * @author PC
 *
 */
public class InvalidInputException extends Exception  {
	public String getMessage() {
		return "Invalid input!";
	}
}
