package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import project5.IUserInterface;
import project5.Translator;
import project5.UserInterface;

/**
 * This is the test class for the Translator class. It tests the translate()
 * methods in three different cases.
 * 
 * @author PC
 *
 */
public class TranslatorTest {
	/**
	 * Test the translate() methods in three cases.
	 */
	@Test
	public void testTranslate() {
//		File myFile = new File("English-French.txt");
//		File myotherFile = new File("French-English.txt");
//
//		// case1: the first character is capitalized and the last character is
//		// punctuation
//		Translator trans = new Translator(myFile, "The lazy boy dances with the smelly jellyfish!");
//		try {
//			trans.readCorpus();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals("La paresseux garcon danse avec la puante meduse!", trans.translate());
//
//		// case2: a source word cannot be found in the corpus
//		trans = new Translator(myotherFile, "The dog is standing.");
//		try {
//			trans.readCorpus();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals("The dog is standing.", trans.translate());
//
//		// case3: capital characters and punctuation in the middle of the sentence
//		trans = new Translator(myotherFile, "Le meduse, puante Chacha.");
//		try {
//			trans.readCorpus();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals("The jellyfish smelly chacha.", trans.translate());
		
		IUserInterface userInterface = new UserInterface();
		try {
		userInterface.runProgram();
		}
		catch (FileNotFoundException e) {
		System.out.println("FIle not found!");
		}
	}
}