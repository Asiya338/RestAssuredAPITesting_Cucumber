package baseclass;

import baseclass.ConfigReader;
import utils.TokenManager;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class TestBase 
{
	protected static RequestSpecification authSpec;
	protected static RequestSpecification bookingSpec;
	protected static String path = System.getProperty("user.dir");
	
	public static RequestSpecification getAuthSpec()
	{
		try 
		{
			ConfigReader.loadConfig(); //load config properties
			PrintStream reqLog = new PrintStream(new FileOutputStream(path + "/src/test/resources/logger/AuthReq.log" , true));
			PrintStream resLog = new PrintStream(new FileOutputStream(path  + "/src/test/resources/logger/AuthRes.log" , true));
			
			//authorization request specification
			authSpec = new RequestSpecBuilder()
						   .setBaseUri(ConfigReader.getProperty("baseuri"))
						   .setAccept(ContentType.JSON)
						   .setContentType(ContentType.JSON)
						   .addFilter(new RequestLoggingFilter(reqLog)) //log into AuthReq.log
						   .addFilter(new ResponseLoggingFilter(resLog))//log into Authres.log
						   .build();
			
		}
		catch(FileNotFoundException e)
		{
			//handle exception if file is not found
			throw new RuntimeException("could not create log reports for authorization : " + e.getMessage());
		}
		return authSpec;
	}
	
	public static RequestSpecification getBookingSpec(String methType)
	{
		try 
		{
			
			ConfigReader.loadConfig(); //load config properties
			PrintStream logs = null;
			
			//handle different HTTP requests
			switch(methType)
			{
				case "GET" : logs =  new PrintStream(new FileOutputStream(path + "/src/test/resources/logger/GetBooking.log" , true));
				break;
				case "POST" : logs =  new PrintStream(new FileOutputStream(path + "/src/test/resources/logger/PostBooking.log" , true));
				break;
				case "DELETE" : logs =  new PrintStream(new FileOutputStream(path  + "/src/test/resources/logger/DelBooking.log" , true));
				break;
			}
			
			//Booking API request specification
			bookingSpec = new RequestSpecBuilder()
					  .setBaseUri(ConfigReader.getProperty("bookingbaseuri"))
					  .setAccept(ContentType.JSON)
					  .setContentType(ContentType.JSON)
					  .addHeader("Authorization", "Bearer " + TokenManager.getToken())
					  .addFilter(new RequestLoggingFilter(logs)) //log into corresponding log file
					  .addFilter(new ResponseLoggingFilter(logs))//log into corresponding log file
					  .build();
		}
		catch(FileNotFoundException e)
		{
			//handle exception if file is not found
			throw new RuntimeException("could not create log reports for booking  : " + e.getMessage());
		}
		return bookingSpec;
	}
	
	public static void main(String[] args)
	{
		authSpec = getAuthSpec();
		return;
	}
}
