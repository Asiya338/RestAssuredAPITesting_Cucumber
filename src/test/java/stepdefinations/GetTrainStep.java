package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import utils.RestAssuredUtils;
import utils.ValidationUtils;

public class GetTrainStep
{
	public static Response response;
	
	//get bookings data by valid train class
	@Given("enter get endpoint with valid trainclass {string} and get request")
	public static void enter_get_endpoint_with_valid_Id_and_get_request(String trainClass)
	{
		response = RestAssuredUtils.getBookingByTrain(trainClass);
	}
	
	//validate bookings data by valid train class
	@When("validate the get trainclass response")
	public static void validate_the_get_trainclass_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateStatusCode(response, 200);
	}
	
	//log bookings data 
	@Then("log the get trainclass results")
	public static void log_the_get_trainclass_results()
	{
		System.out.println(">>>Request and Response are logged in GetBooking.log");
	}
}
