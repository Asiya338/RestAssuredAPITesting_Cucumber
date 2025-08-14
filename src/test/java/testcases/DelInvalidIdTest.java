package testcases;

import utils.RestAssuredUtils;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class DelInvalidIdTest 
{
	//Delete booking data by invalid bookingId
	@Parameters("invalidId")
	@Test(description="Delete booking data by invalid bookingId")
	public static void deleteByInvalidId(@Optional("909090")int invalidId)
	{
		Response response = RestAssuredUtils.delBookingById(invalidId);
		Assert.assertNull(response , "Response must be null!!!");
	}
	
	//Get bookings data after deletion with invalid booking id
	@Test(description="Get bookings data after deletion with invalid booking id")
	public static void getBooking()
	{
		RestAssuredUtils.getAllBookings();
	}
}
