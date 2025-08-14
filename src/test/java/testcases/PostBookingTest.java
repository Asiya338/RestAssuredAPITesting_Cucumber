
package testcases;

import utils.RestAssuredUtils;
import utils.JsonReaderUtil;
import pojoclass.BookingAPIPage;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class PostBookingTest 
{
	//Post booking data from BookingData.json
	@Test(description="Post booking data from BookingData.json")
	public static void postBooking()
	{
		String path = System.getProperty("user.dir");
		BookingAPIPage booking =    JsonReaderUtil.getBookingData(path + "/src/test/resources/testdata/BookingData.json");
		Response response = RestAssuredUtils.addBooking(booking);
		Assert.assertNotNull(response , "Check response is not null");
	}
	
	//Get response after adding bookings data
	@Test(description="Get response after adding bookings data")
	public static void getBooking()
	{
		RestAssuredUtils.getAllBookings();
	}
}
