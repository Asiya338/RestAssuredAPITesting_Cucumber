package testcases;

import utils.RestAssuredUtils;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class DeleteIdTest 
{
	// to delete booking data by vlaid bookingid
	@Parameters("bookingId")
	@Test(description="Delete booking data by valid bookingId")
	public static void deleteById(@Optional("1001") int bookingId)
	{
		Response response = RestAssuredUtils.delBookingById(bookingId);
		Assert.assertNotNull(response , "Check response is not null");
	}
	
	//Get bookings data after deletion with valid booking id
	@Test(description="Get bookings data after deletion with valid booking id")
	public static void getBooking()
	{
		RestAssuredUtils.getAllBookings();
	}
}
