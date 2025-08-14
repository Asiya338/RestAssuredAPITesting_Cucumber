@BookingAPI

#RestAssured API Testing Booking train API

Feature: Booking Functionality RestAssured API
				
	
	Scenario: To validate add booking from JSON - post request 
		Given enter post endpoint and post request
		When validate the post response
		Then log the post results
		
	Scenario: To validate view booking list - get request 
		Given enter get endpoint and get request
		When validate the get list response
		Then log the get list results
		
	Scenario: To validate view booking by valid Id - get request 
		Given enter get endpoint with valid Id 1001 and get request
		When validate the get by id response
		Then log the get by id results
		
	Scenario: To validate view booking by valid trainClass - get request 
		Given enter get endpoint with valid trainclass 'THIRDAC' and get request
		When validate the get trainclass response
		Then log the get trainclass results
		
	Scenario: To validate view booking by invalid Id - get request 
		Given enter get endpoint with invalid Id 100005 and get request
		When validate the get by invalidid response
		Then log the get by invalidid results
		
	Scenario: To validate delete booking by valid Id - delete request 
		Given enter delete endpoint with valid Id 1001 and delete request
		When validate the del response by id 
		Then log the del by id results
		
	Scenario: To validate delete booking by invalid Id - delete request 
		Given enter delete endpoint with invalid Id 1000078 and delete request
		When validate the del by invalidid response 
		Then log the del by invalidid results
		
	