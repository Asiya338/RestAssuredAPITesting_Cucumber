package utils;

import pojoclass.BookingAPIPage;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import baseclass.TestBase;


public class RestAssuredUtils 
{
	//reusable functions for get, delete and post http requests
	
	//to add booking data using bookingapi pojoclass
	public static Response addBooking(BookingAPIPage booking)
	{
		System.out.println("Add booking data to train API");
		return given()
			   .spec(TestBase.getBookingSpec("POST"))
			   .contentType("application/x-www-form-urlencoded")
			   .formParam("bookingId" , booking.getBookingId())
			   .formParam("bookingDate" , booking.getBookingDate())
			   .formParam("departCity", booking.getDepartCity())
			   .formParam("arrivalCity" , booking.getArrivalCity())//use form params to post data
			   .formParam("passengerCount" , booking.getPassengerCount())
			   .formParam("trainName" , booking.getTrainName())
			   .formParam("passengerName" , booking.getPassengerName())
			   .formParam("trainClass" , booking.getTrainClass())
			   .formParam("ticketType" , booking.getTicketType())
			   .when()
			   .post(Resource.addBooking.getResource());
		
	}
	
	//to get all bookings data
	public static Response getAllBookings()
	{
		System.out.println("Get bookings data");
		return given()
			   .spec(TestBase.getBookingSpec("GET"))
			   .when()
			   .get(Resource.viewBookingList.getResource());
	}
	
	//to get specific booking data by id
	public static Response getBookingById(int bookingId)
	{
		System.out.println("Get booking by bookingId");
		return given()
			   .spec(TestBase.getBookingSpec("GET"))
			   .pathParam("bookingId" , bookingId)
			   .when()
			   .get(Resource.viewBookingId.getResource());
	}
	
	//to get specific booking data by trainclass
	public static Response getBookingByTrain(String trainClass)
	{
		System.out.println("Get booking by trainClass");
		return given()
			   .spec(TestBase.getBookingSpec("GET"))
			   .queryParam("trainClass", trainClass)
			   .when()
			   .get(Resource.viewBookingByClass.getResource());
	}
	
	//to dleete specific booking data by id
	public static Response delBookingById(int bookingId)
	{
		
		System.out.println("Delete Booking by bookingId");
		return given()
			   .spec(TestBase.getBookingSpec("DELETE"))
			   .pathParam("bookingId", bookingId)
			   .when()
			   .delete(Resource.delBookingId.getResource());
	}
}
