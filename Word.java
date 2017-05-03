package Tarea2;

import java.util.ArrayList;
import java.util.Hashtable;

public class Word 
{
	private String phrase;
	private String[] splitWords;
	
	
	public String[] GetWords(String phrase) throws Exception //get the separated words of the phrase
	{
		String space = " ";
		this.splitWords = phrase.split(space); //asings the words to the variable splitWords
		ThreadHelper thread = new ThreadHelper(splitWords); //create the constructor
		thread.getLength(splitWords); //got the len of the words
		thread.start(); //starts the thread
		return splitWords;
	}
	
	ThreadHelper thread = new ThreadHelper(splitWords); //the constructor for the analyze method
	HashContent cont = HashContent.getInstance(); //the singleton
	
	public void analyzeWords(String[] splitWords, int i) throws Exception //function that analyze each word into the thread
	{
		cont.verifyWord(splitWords[i].toString()); //converts to string the correspond word
	}

	
	//Gets and Sets of the phrase to obtain it
	public String getPhrase()
	{
		return phrase;
	}

	public void setPhrase(String phrase)
	{
		this.phrase = phrase;
	}
}
