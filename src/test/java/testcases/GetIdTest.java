package testcases;

import utils.RestAssuredUtils;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class GetIdTest 
{
	//Get booking data by bookingId
	@Parameters("bookingId")
	@Test(description="Get booking data by bookingId")
	public static void getById(@Optional("1001")int bookingId)
	{
		Response response = RestAssuredUtils.getBookingById(bookingId);
		Assert.assertNotNull(response , "Check response is not null");
	}
}
