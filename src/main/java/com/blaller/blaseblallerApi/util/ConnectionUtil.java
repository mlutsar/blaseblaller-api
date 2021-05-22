package com.blaller.blaseblallerApi.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * An utility class to connect to a webpage. Since this project is specifically for reading Blaseball APIs,
 * we expect all webpages to be raw json and all requests to be basically GET.
 * @author mlutsar
 *
 */
public class ConnectionUtil {
	
	/**
	 * An utility method to get the contents of a webpage.
	 * @param address URL of the webpage to be read
	 * @return String The contents of the webpage as-is, no formatting or filtering are done. If there is 
	 * an exception when connecting to the address, null is returned
	 */
	public static String getJson(String address) {
		try {
		    URL myURL = new URL(address);
		    URLConnection conn = myURL.openConnection();
		    
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer json = new StringBuffer();
	        
	        while ((inputLine = in.readLine()) != null) {
	        	json.append(inputLine);
	        }
	        in.close();
	        return json.toString();
		}
		catch (Exception e) {
		    System.out.println("Exception when connecting to URL " + address + ", nested exception is" + e.getStackTrace());
		}
		return null;
	}
}
