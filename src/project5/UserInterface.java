/**
 * 
 */
package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class interacts with the user: requests input, reads in user input and
 * uses the appropriate objects and methods to perform the required tasks.
 * 
 * @author PC
 *
 */
public class UserInterface implements IUserInterface {
	private File corpusFile;
	private String sourceText;
	private String translatedText;

	/**
	 * Runs the program by calling necessary methods.
	 */
	@Override
	public void runProgram() throws FileNotFoundException {
		// TODO Auto-generated method stub
		greeting();
		boolean stop = false;
		String userAnswer;
		while (!stop) {
			setCorpusFileName();
			setSourceText();
			translate();
			System.out.println("Another translation? (y/n)");
			boolean success = false;
			while (!success) {
				try {
					userAnswer = askIfQuit();
					if (userAnswer.equals("n")) {
						success = true;
						stop = true;

					} else if (userAnswer.equals("y")) {
						success = true;
					}
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid input! Please enter 'y' or 'n':");
				}

			}

		}

	}

	/**
	 * Gets users input indicating whether or not they want to quit.
	 * 
	 * @return users input indicating whether or not they want to quit
	 * @throws InvalidInputException
	 */
	private String askIfQuit() throws InvalidInputException {

		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		answer = answer.toLowerCase();
		if (!((answer.equals("n")) || (answer.equals("y")))) {
			throw new InvalidInputException();
		}
		return answer;
	}

	/**
	 * Displays a greeting to the user and indicates briefly what the program does.
	 */
	@Override
	public void greeting() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Translator! Bienvenue!!");
		System.out.println("You can translate sentences from English to French and vice versa!");
	}

	/**
	 * Displays the translation options to the user and, after reading the option
	 * selected by the user, sets the name of the corpus file.
	 */
	@Override
	public void setCorpusFileName() {
		// TODO Auto-generated method stub
		System.out.println("So, what would you like to do? Please select from one of the following:");
		System.out.println(">> From English to French: (input '1')");
		System.out.println(">> From French to English: (input '2')");
		boolean success = false;
		Scanner scan = new Scanner(System.in);
		int input;

		while (!success) {
			try {
				String userInp = scan.nextLine();
				input = Integer.parseInt(userInp);
				if (input != 1 && input != 2) {
					throw new InvalidInputException();
				} else if (input == 1) {
					corpusFile = new File("English-French.txt");
					System.out.println("Translate from English to French.");
					success = true;
				} else if (input == 2) {
					corpusFile = new File("French-English.txt");
					System.out.println("Translate from French to English.");
					success = true;
				}

			} catch (InvalidInputException e) {
				System.out.println("Invalid input! Input should be 1 or 2. Please try again:");

			} catch (NumberFormatException a) {
				System.out.println("Invalid input! Input must be an integer! Try again:");

			}
		}

	}

	/**
	 * Requests the text the user wants to translate (i.e. the source text) and sets
	 * the source text field.
	 */
	@Override
	public void setSourceText() {
		// TODO Auto-generated method stub
		boolean success = false;
		while (!success) {
			try {
				System.out.println("Input the sentence for translation:");
				Scanner scan = new Scanner(System.in);
				sourceText = scan.nextLine();
				if (sourceText.equals("")) {
					throw new EmptyStringException();
				}
				success = true;
			} catch (EmptyStringException e) {
				System.out.println("Invalid (empty) string!");
			}
		}

	}

	/**
	 * Uses the Translator object to translate the source text and displays the
	 * translated text to the user.
	 */
	@Override
	public void translate() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Translator trans = new Translator(corpusFile, sourceText);
		trans.readCorpus();
		translatedText = trans.translate();
		System.out.println("Your sentence translated is:");
		System.out.println(">> " + translatedText);

	}

}
