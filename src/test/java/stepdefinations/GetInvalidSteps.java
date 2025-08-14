package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import utils.RestAssuredUtils;
import utils.ValidationUtils;

public class GetInvalidSteps
{
	public static Response response;
	
	// get booking data by invalid id
	@Given("enter get endpoint with invalid Id {int} and get request")
	public static void enter_get_endpoint_with_invalid_Id_and_get_request(int bookingId)
	{
		response = RestAssuredUtils.getBookingById(bookingId);
	}
	
	// validate booking data by invalid id
	@When("validate the get by invalidid response")
	public static void validate_the_get_by_invalidid_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateStatusCode(response, 404);
	}
	
	// log booking data by invalid id
	@Then("log the get by invalidid results")
	public static void log_the_get_by_invalidid_results()
	{
		System.out.println(">>>Request and Response are logged in GetBooking.log");
	}
}
