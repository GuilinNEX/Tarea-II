package Tarea2;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Enumeration;

public class HashContent implements Observable
{
	private static HashContent Instance; //To implements singleton
	private Hashtable<String, String> hashtable = new Hashtable<String, String>(); //this creates an Hashtable
	private ArrayList<Observadores> lista = new ArrayList<Observadores>() ;
	
	private String result;
	
	private HashContent() //The constructor without parameters
	{
	}
	
	public synchronized static HashContent getInstance() //The method that synchronize the HashContent
	{
		if (Instance==null)
		{
			Instance = new HashContent(); //Create the instance
		}
		return Instance;
	}
	
	public boolean verifyWord(String pWord) throws Exception //verify if the word is in the hashtable
	{
		try
		{
			if (hashtable.containsKey(pWord) == true) //if the word is in the hashtable
			{
				showRequest(pWord);
			}
			else
			{
				Request req = new Request(); //else do the request
				req.getRequest(pWord); //request function
			}
		}
		catch (Exception e) //to catch some problem
		{
			System.out.println("Cae catch");
		}
		return true;
	}
	
	public void newWord(String pWord, String pResult) //After do the request come here to put it in the hashtable
	{
		
		hashtable.put(pWord, pResult);
		System.out.println(pWord + "	HTML	" + hashtable.get(pWord));
	//	notificar();
		
		this.result = pResult;
		/*Enumeration names;
	    String str;
	    double bal;
	    // Show all balances in hash table.
	    names = hashtable.keys();
	      
	      while(names.hasMoreElements()) {
	         str = (String) names.nextElement();
	         System.out.println(str + " imprime " + hashtable.get(str));
	      } */       
	}
	
	public void showRequest(String pWord) //function that show the word if is in the hashtable
	{
		System.out.println(pWord + "	HTML	" + hashtable.get(pWord));
	}
	
	private void notificar()
	{
        for (Iterator<Observadores> it = lista.iterator(); it.hasNext();) 
        {
        	Observadores iObserver = it.next();
            iObserver.actualizar();
        }
    }

	@Override
	public void agregarObservador(Observadores observador) 
	{
		this.lista.add(observador);
	}

	@Override
	public String getRequest() {
		// TODO Auto-generated method stub
		return this.result;
	}
	
	
	
	
}
