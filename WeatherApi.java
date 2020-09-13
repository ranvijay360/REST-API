package com.restapiassign.demo;

import java.net.*;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherApi {
	static String inputLine;
	static Scanner sc = new Scanner(System.in);
	private static HttpURLConnection con;
	public static void main(String[] args) {
		try {
            /*LOADING THE URL FROM URL CLASS AND THEN SETTING HTTP CONNECTION*/
            URL obj = 
            	new URL("https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responcecode=con.getResponseCode();
			
			if(responcecode==200)
			{
				System.out.println("Connection Established successfully");
	            while(sc.hasNext())
				{
					inputLine+=sc.nextLine();
				}
				
	            WeatherApi rest = new WeatherApi();
	            while(true) {
	            	/*TAKING CHOICE FROM THE USER.*/
	            	System.out.println("Select Your Choice for Forecast\n"
	            			+ "Press 1 to Get Weather/Temperature\n"
	            			+ "Press 2 to Get Wind Speed\n"
	            			+ "Press 3 to Get Pressure\n"
	            			+ "Otherwise Press 0 for Exit");
	            	int choice = sc.nextInt();
	            	/*THEN BY USING SWITCH CASE WE WILL FOLLOW 
	            	 * CONDITION ASKED IN THE QUESTION
	            	 * If the user press 1, Prompt the user for the date then print the temp of the input date.
						If the user press 2, Prompt the user for the date then print the wind.speed of the input date.
						If the user press 3, Prompt the user for the date then print the pressure of the input date.
						If the user press 0, Terminate the program.*/
	            	switch(choice)
	            	{
	            		case 1:
	            			rest.forecastTemperature(inputLine);
	            			break;
	            		case 2:
	            			rest.forecastWind(inputLine);
	            			break;
	            		case 3:
	            			rest.forecastPressure(inputLine);
	            			break;
	            		case 0:
	            			System.out.println("...");
	            			System.exit(0);
	            			break;
	            		default:
	            			System.out.println("You Have Entered Wrong Choice, Select From above choice");
	            			sc.close();
	            	}
	            }
			}
	        else
			{
				System.out.println("Something Went Wrong! Connection Not Established");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void forecastTemperature(String inputLine) {
		try {
			/*tAKING USER INPUT IN CORRECT FORMAT AS MENTION BELOW*/
			System.out.println("Enter date in Format yyyy-MM-dd: ");	
			String date1;
			date1 = sc.nextLine();
			JSONObject object=new JSONObject(inputLine);
			JSONArray list=object.getJSONArray("list");
			for(int i=0;i<list.length();i++)
			{
				JSONObject inList=list.getJSONObject(i);
				/*SPLITTING THE OBJECT DATE VALUE  i.e, "2019-03-27 18:00:00" 
				 * TILL WE GET THE 1ST SPACE AND THEN STORING IT IN A TEMPORARY VARIABLE */
				String dt_txt=inList.getString("dt_txt");
				String[] dateCheck = dt_txt.split(" ");
				String ab1="";
				for(String ab:dateCheck)
				{
				    ab1 = ab;
				    break;
				}
				/*NOW CHECKING THE SPLIT DATE i.e, 2019-03-27 OR 
				 * Ith POSITION DATE IS EQUAL TO THE DATE PRESENT IN JSON OR NOT*/
				if(ab1 == date1 )
				{
					System.out.print("Temperature on "+inList.getString("dt_txt")+"is:");
					JSONObject main=inList.getJSONObject("main");
					System.out.println(main.getDouble("temp"));
				}
				else {
					System.out.println("Enter correct date");
				}
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void forecastWind(String inputLine) {
		try {
			/*tAKING USER INPUT IN CORRECT FORMAT AS MENTION BELOW*/
			System.out.println("Enter date in Format yyyy-MM-dd: ");	
			String date1;
			date1 = sc.nextLine();
			JSONObject object=new JSONObject(inputLine);
			JSONArray list=object.getJSONArray("list");
			for(int i=0;i<list.length();i++)
			{
				JSONObject inList=list.getJSONObject(i);
				String dt_txt=inList.getString("dt_txt");
				/*SPLITTING THE OBJECT DATE VALUE  i.e, "2019-03-27 18:00:00" 
				 * TILL WE GET THE 1ST SPACE AND THEN STORING IT IN A TEMPORARY VARIABLE */
				String[] dateCheck = dt_txt.split(" ");
				String ab1="";
				for(String ab:dateCheck)
				{
				    ab1 = ab;
				    break;
				}
				/*NOW CHECKING THE SPLIT DATE i.e, 2019-03-27 OR 
				 * Ith POSITION DATE IS EQUAL TO THE DATE PRESENT IN JSON OR NOT*/
				if(ab1 == date1 )
				{
					System.out.print("Wind Speed on "+inList.getString("dt_txt")+"is:");
					JSONObject main=inList.getJSONObject("wind");
					System.out.println(main.getDouble("speed"));
				}
				else {
					System.out.println("Enter correct date");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void forecastPressure(String inputLine) {
		try {
			/*tAKING USER INPUT IN CORRECT FORMAT AS MENTION BELOW*/
			System.out.println("Enter date in Format yyyy-MM-dd: ");	
			String date1;
			date1 = sc.nextLine();
			JSONObject object=new JSONObject(inputLine);
			JSONArray list=object.getJSONArray("list");
			for(int i=0;i<list.length();i++)
			{
				JSONObject inList=list.getJSONObject(i);
				String dt_txt=inList.getString("dt_txt");
				/*SPLITTING THE OBJECT DATE VALUE  i.e, "2019-03-27 18:00:00" 
				 * TILL WE GET THE 1ST SPACE AND THEN STORING IT IN A TEMPORARY VARIABLE */
				String[] dateCheck = dt_txt.split(" ");
				String ab1="";
				for(String ab:dateCheck)
				{
				    ab1 = ab;
				    break;
				}
				/*NOW CHECKING THE SPLIT DATE i.e, 2019-03-27 OR 
				 * Ith POSITION DATE IS EQUAL TO THE DATE PRESENT IN JSON OR NOT*/
				if(ab1 == date1 )
				{
					System.out.print("Pressure on "+inList.getString("dt_txt")+"is:");
					JSONObject main=inList.getJSONObject("main");
					System.out.println(main.getDouble("pressure"));
				}
				else {
					System.out.println("Enter correct date");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
