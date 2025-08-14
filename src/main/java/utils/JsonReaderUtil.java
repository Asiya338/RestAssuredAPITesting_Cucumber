package utils;

import java.io.File;
import java.io.IOException;
import pojoclass.BookingAPIPage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderUtil 
{
	//to read data from JSON file
	public static BookingAPIPage getBookingData(String filepath) 
	{
		try {
		 ObjectMapper mapper = new ObjectMapper();
		 System.out.println("Reading JSON data from BookingData.json"); //to map it into corresponding pojoclass
		 return  mapper.readValue(new File(filepath), BookingAPIPage.class);
		}
		catch(IOException e)
		{
			//handle exception 
			throw new RuntimeException(">>> Error in reading JSON data : " + e.getMessage());
		}
	}
}
