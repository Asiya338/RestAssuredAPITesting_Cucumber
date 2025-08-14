package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import utils.RestAssuredUtils;
import utils.ValidationUtils;

public class DelInvalidIdSteps
{
	public static Response response;
	
	//enter invalid id to delete http request by invlaid booking id
	@Given("enter delete endpoint with invalid Id {int} and delete request")
	public static void enter_delete_endpoint_with_invalid_Id_and_delete_request(int bookingId)
	{
		response = RestAssuredUtils.delBookingById(bookingId);
	}
	
	//validate delete bookign data by invlaid booking id
	@When("validate the del by invalidid response")
	public static void validate_the_del_by_invalidid_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateResponseHeader(response, "application/json");
		ValidationUtils.validateStatusCode(response, 404);
	}
	
	//log delete data by invalid bookingid
	@Then("log the del by invalidid results")
	public static void log_the_del_by_invalidid_results()
	{
		System.out.println(">>>Request and Response are logged in DelBooking.log");
	}
}
