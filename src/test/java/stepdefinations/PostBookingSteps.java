package stepdefinations;

import utils.JsonReaderUtil;
import utils.RestAssuredUtils;
import utils.ValidationUtils;
import pojoclass.BookingAPIPage;

import io.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostBookingSteps 
{
	public static Response response;
	
	//add booking data from JSON file
	@Given("enter post endpoint and post request")
	public static void enter_post_endpoint_and_post_request()
	{
		String path = System.getProperty("user.dir");
		BookingAPIPage booking =    JsonReaderUtil.getBookingData(path + "/src/test/resources/testdata/BookingData.json");
		response = RestAssuredUtils.addBooking(booking);
	}
	
	// validate added data
	@When("validate the post response")
	public static void validate_the_post_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseHeader(response, "application/json");
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateStatusCode(response, 200);
	}
	
	//log add bookings data
	@Then("log the post results")
	public static void log_the_post_results()
	{
		System.out.println(">>>Request and Response are logged in PostBooking.log");
	}
	
}
