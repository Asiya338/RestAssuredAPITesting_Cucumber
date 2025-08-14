@Auth

#RestAssured API Testing on Authorization API
 
Feature: Authorization Functionality RestAssured API

#to get auth code with valid credentials and access token
				
	Scenario: To validate auth code and access token
		Given enter auth code to get access token 
		When validate the auth response
		Then log the auth results