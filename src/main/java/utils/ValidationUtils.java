package utils;

import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ValidationUtils 
{
	//reusable functions for validation
	
	//to validate response type
	public static void validateResponse(Response response)
	{
		String responseType = response.getContentType();
		assertThat("Response is not JSON!!!" , responseType.toLowerCase() , containsString("application/json"));
	}
	
	//to validate response statuscode
	public static void validateStatusCode(Response response , int expectedStatusCode)
	{
		assertThat("StatusCode mismatch!!!" , response.getStatusCode() , equalTo(expectedStatusCode));
	}
	
	//to validate response ttime
	public static void validateResponseTime(Response response)
	{
		assertThat("Response time mismatch!!!" , response.getTime() , lessThanOrEqualTo(Long.valueOf(2000)));
	}
	
	//to vlaidtae response header
	public static void validateResponseHeader(Response response , String expectedContentType)
	{
		assertThat("Content-Type mismatch!!!" , response.getHeader("Content-Type") , containsString(expectedContentType));
	}	
	
}
