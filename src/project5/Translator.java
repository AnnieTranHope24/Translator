/**
 * 
 */
package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class helps translate the source text.
 * @author PC
 *
 */
public class Translator implements ITranslator {
	private File corpusFile;
	private String translatedText;
	private HashMap<String, String> languages;
	private String sourceText;
	/**
	 * Create a Translator.
	 * @param corpusFile the corpus file
	 * @param sourceText the source text
	 */
	public Translator(File corpusFile, String sourceText) {
		this.corpusFile = corpusFile;
		this.sourceText = sourceText;
		translatedText = "";
		languages = new HashMap<>();
	}
	/**
	 * Reads the data from the input file and stores the data in a HashMap.
	 */
	@Override
	public void readCorpus() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(corpusFile);

		while (reader.hasNext()) {
			String[] pair = reader.nextLine().trim().split(",");
			if (pair.length != 1) {
				languages.put(pair[0], pair[1]);
			}

		}

	}
	/**
	 * Does some processing on the source text (to be translated) and calls the method consultLookup to
	 * perform the translation. It returns the translated text.
	 * @return the translated text
	 */
	@Override
	public String translate() {
		// TODO Auto-generated method stub
		String temp = sourceText;
		sourceText = sourceText.toLowerCase();
		consultLookup();
		if(Character.isUpperCase(temp.charAt(0))) {
			translatedText = translatedText.substring(0, 1).toUpperCase() + translatedText.substring(1);
		}
		int i = temp.length()-1;
		if(!Character.isLetter(temp.charAt(i)) && !Character.isDigit(temp.charAt(i)) ) {
			translatedText += temp.substring(i);
		}
		return translatedText;
	}
	/**
	 * Builds up the translated text.
	 */
	@Override
	public void consultLookup() {
		// TODO Auto-generated method stub
		String[] elements = sourceText.split("\\P{L}+");
		for (int i = 0; i < elements.length; i++) {
			if (i == 0) {
				translatedText += lookup(elements[i]);
			} else {
				translatedText += " " + lookup(elements[i]);
			}
		}
	}
	/**
	 * Looks up the word to be translated 
	 * @param key
	 * @return the translated word
	 */
	private String lookup(String key) {
		String translatedWord;
		if (languages.get(key) != null) {
			translatedWord = languages.get(key);
		} else {
			translatedWord = key;
		}
		return translatedWord;

	}

}
