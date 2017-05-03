package Tarea2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Request
{
	private static final String Url = null;
	private String searchWord;
	private String route = "http://www.google.com/search?q="; //default rout
	private String result;

	private final String USER_AGENT = "Mozilla/5.0";
	private String Request;

	/*public static void main(String[] args) throws Exception 
	{

		Request http = new Request();

		System.out.println("Testing 1 - Send Http GET request");
		http.getRequest();
		}*/

	// HTTP GET request
	public String getRequest(String searchWord) throws Exception {

		route = route + searchWord;

		URL obj = new URL(route);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		//System.out.println("/nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		result = response.toString();
		//System.out.println(result);
		
		HashContent cont = HashContent.getInstance();
		cont.newWord(searchWord, result);
		return result;
	}
	
	
	
	
	
	
	public String getJackson(String direction) throws Exception {

		//route = route + searchWord;

		URL obj = new URL(direction);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		//System.out.println("/nSending 'GET' request to URL : " + url);
		//System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		result = response.toString();
		//System.out.println(result);
		
		//HashContent cont = HashContent.getInstance();
		//cont.newWord(searchWord, result);
		return result;
	}
}