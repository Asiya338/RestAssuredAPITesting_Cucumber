package testcases;

import utils.RestAssuredUtils;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Assert;

public class GetListTest
{
	//Get the bookings data from train API
	@Test(description= "Get the bookings data from train API")
	public static void getList()
	{
		Response response = RestAssuredUtils.getAllBookings();
		Assert.assertNotNull(response , "Check response is not null");
	}
}
