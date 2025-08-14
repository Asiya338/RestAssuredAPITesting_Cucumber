package stepdefinations;

import io.cucumber.java.en.Given;
import utils.*;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.response.Response;


public class AuthAccessSteps 
{
	public static Response response;

	//to generate access token
	@Given("enter auth code to get access token")
	public static void enter_auth_code_to_get_access_token()
	{
		response = TokenManager.generateToken();
	}
	
	// to validate auth response
	@When("validate the auth response")
	public static void validate_the_auth_response()
	{
		ValidationUtils.validateResponse(response);
		ValidationUtils.validateResponseHeader(response, "application/json");
		ValidationUtils.validateResponseTime(response);
		ValidationUtils.validateStatusCode(response, 200);
	}
	
	//to log auth results
	@Then("log the auth results")
	public static void log_the_auth_results()
	{
		System.out.println(">>>Request and Response are logged:");
	}
}
