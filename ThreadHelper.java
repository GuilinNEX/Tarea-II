package Tarea2;

public class ThreadHelper extends Thread
{
	private long timer;
	private String[] words;
	private int helper = 0;
	
	public ThreadHelper(String[] words)
	{
		this.words = words;
	}
	
	public void run() //run the thread
	{  	
		Word word = new Word();
		int wordsLen = getLength(this.words); //get the len of the phrase 
		while (helper < wordsLen) //while the helper been less than the length
		{
			try {
				word.analyzeWords(this.words, helper);//goes to the function and realize the analysis
				getTime(); //call the function to get the time of the search
				helper++;
				Thread.sleep(5000); //the sleep of 5 seconds
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public long getTime() //function that get the time of the search
	{
		timer = System.currentTimeMillis();
		System.out.println(timer + " Tiempo de busqueda");
		return timer;
	}
	
	public int getLength(String[] splitWords) //get the len of the phrase
	{
		int len = splitWords.length;
		return len;
	}
	
}
