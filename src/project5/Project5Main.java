package project5;

import java.io.File;
import java.io.FileNotFoundException;
/**
 * This is the main class of the project.
 * @author PC
 *
 */
public class Project5Main {

	public static void main(String[] args) {
		IUserInterface userInterface = new UserInterface();
		try {
		userInterface.runProgram();
		}
		catch (FileNotFoundException e) {
		System.out.println("FIle not found!");
		}


	}

}
