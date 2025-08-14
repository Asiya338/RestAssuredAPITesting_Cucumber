package testcases;

import utils.RestAssuredUtils;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class GetTrainTest 
{
	//Get booking data by trainClass
	@Parameters("trainClass")
	@Test(description="Get booking data by trainClass")
	public static void getByTrainClass(@Optional("THIRDAC") String trainClass)
	{
		Response response = RestAssuredUtils.getBookingByTrain(trainClass);
		Assert.assertNotNull(response , "Check response is not null");
	}
}
