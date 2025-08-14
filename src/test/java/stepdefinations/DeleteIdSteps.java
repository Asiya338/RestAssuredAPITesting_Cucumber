package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import utils.RestAssuredUtils;
import utils.ValidationUtils;

public class DeleteIdSteps
{
	public static Response response;
	
	//to delete by valid bookingId
	@Given("enter delete endpoint with valid Id {int} and delete request")
	public static void enter_delete_endpoint_with_valid_Id_and_delete_request(int bookingId)
	{
		response = RestAssuredUtils.delBookingById(bookingId);
	}
	
	//validate delete repsonse by booking id
	@When("validate the del response by id")
	public static void validate_the_del_response_by_id()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateResponseHeader(response, "application/json");
		ValidationUtils.validateStatusCode(response, 200);
	}
	
	// log the delete data by booking id
	@Then("log the del by id results")
	public static void log_the_del_by_id__results()
	{
		System.out.println(">>>Request and Response are logged in DelBooking.log");
	}
}
