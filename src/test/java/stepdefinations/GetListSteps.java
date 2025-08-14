package stepdefinations;

import io.restassured.response.Response;
import utils.JsonReaderUtil;
import utils.RestAssuredUtils;
import utils.ValidationUtils;
import pojoclass.BookingAPIPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetListSteps 
{
	public static Response response;
	
	//get all bookings data
	@Given("enter get endpoint and get request")
	public static void enter_get_endpoint_and_get_request()
	{
		response = RestAssuredUtils.getAllBookings();
	}
	
	// validate booking data
	@When("validate the get list response")
	public static void validate_the_get_list_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseHeader(response, "application/json");
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateStatusCode(response, 200);
	}
	
	//log bookings data
	@Then("log the get list results")
	public static void log_the_get_list_results()
	{
		System.out.println(">>>Request and Response are logged in GetBooking.log");
	}
	
}
