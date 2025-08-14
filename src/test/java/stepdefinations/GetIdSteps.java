package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import utils.RestAssuredUtils;
import utils.ValidationUtils;

public class GetIdSteps
{
	public static Response response;
	
	//get booking list by valid id
	@Given("enter get endpoint with valid Id {int} and get request")
	public static void enter_get_endpoint_with_valid_Id_and_get_request(int bookingId)
	{
		response = RestAssuredUtils.getBookingById(bookingId);
	}
	
	// validate booking data by vlaid id
	@When("validate the get by id response")
	public static void validate_the_get_by_id_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateStatusCode(response, 200);
	}
	
	// log bookings data by valid id
	@Then("log the get by id results")
	public static void log_the_get_by_id_results()
	{
		System.out.println(">>>Request and Response are logged in GetBooking.log");
	}
}
