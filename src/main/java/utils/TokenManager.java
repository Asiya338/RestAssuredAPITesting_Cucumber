package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import baseclass.ConfigReader;
import baseclass.TestBase;

public class TokenManager 
{
	private static String access_token;
	
	//to get the access token
	public static String getToken()
	{
		if (access_token == null) {
	        generateToken();
	    }
		return access_token;
	}
	
	// to generate access token from auth_Code
	public static Response  generateToken()
	{
		ConfigReader.loadConfig();
		//get authorization response
		Response authResp = given()
						   .spec(TestBase.getAuthSpec())
						   .baseUri(ConfigReader.getProperty("baseuri"))
						   .basePath(ConfigReader.getProperty("authlogin"))
						   .accept(ConfigReader.getProperty("accept"))
						   .contentType("application/x-www-form-urlencoded")
						   .formParam("username", ConfigReader.getProperty("username"))
						   .formParam("password", ConfigReader.getProperty("password"))
						   .post();
		String auth_code = authResp.jsonPath().getString("auth_code"); // auth code
		
		System.out.println("auth_code : "  + auth_code);
		
		
		Response tokenResp = given()
				           .spec(TestBase.getAuthSpec())
						   .baseUri(ConfigReader.getProperty("baseuri"))
						   .basePath(ConfigReader.getProperty("authtoken"))
						   .accept(ConfigReader.getProperty("accept"))
						   .contentType("application/x-www-form-urlencoded")
						   .formParam("auth_code", auth_code)
						   .post();
		access_token = tokenResp.jsonPath().getString("access_token"); // access token
		
		System.out.println("access_token : "  + access_token);
		return authResp;
	}
}
