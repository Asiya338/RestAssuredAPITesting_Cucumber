package testcases;
 
import utils.RestAssuredUtils;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class GetInvalidIdTest 
{
	//Get booking data by invalid bookingId
	@Parameters("invalidId")
	@Test(description="Get booking data by invalid bookingId")
	public static void getByInvalidId(@Optional("909090")int invalidId)
	{
		Response response = RestAssuredUtils.getBookingById(invalidId);
		Assert.assertNull(response , "Response must be null!!!");
	}
}
