package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	public static Properties props = new Properties();
	
	public static void loadConfig()
	{
		try 
		{
		//get stream of configuration properties 
		FileInputStream fis = new FileInputStream("src/test/resources/config/Configuration.properties");
	    
		props.load(fis); //load the properties
	    fis.close(); //close file stream
		}
		catch(IOException e)
		{
			e.printStackTrace(); //for getting error message
		}
	}
	
	public static String getProperty(String key)
	{
		return props.getProperty(key); // get the corresponding property value
	}
}
