package utils;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class BrokenLinkChecker {
	
	
	public static HttpURLConnection httpConn;

	

	public static int verifyLink(String urlLink) throws IOException
	{
		//Sometimes we may face exception "java.net.MalformedURLException". Keep the code in try catch block to continue the broken link analysis
		try
		{
			//Use URL Class - Create object of the URL Class and pass the urlLink as parameter 
			
			URL link = new URL(urlLink);
			
			// Create a connection using URL object (i.e., link)
			httpConn = (HttpURLConnection)link.openConnection();
			
			//Set the timeout for 2 seconds
			httpConn.setConnectTimeout(2000);
			
			//Connect using connect method
			httpConn.connect();
			
			//use getResponseCode() to get the response code
			if(httpConn.getResponseCode()==200)
			{
				System.out.println(urlLink + "-" + httpConn.getResponseMessage());
			}
			
			else
			{
				System.out.println(urlLink+" - "+httpConn.getResponseMessage());
			}
			
		}
		
		//getResponseCode method returns = IOException - if an error occurred connecting to the server.
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
			
			return (httpConn.getResponseCode());
			
		
	
	}
}
