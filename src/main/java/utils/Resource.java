package utils;

//centralized endpoints manager using enum 
public enum Resource 
{
    addBooking("/addBooking"),  // to add booking data
    viewBookingList("/viewBookingList"), // to view booking data
    viewBookingId("/viewBookingById/{bookingId}"), // path param : view by id
    viewBookingByClass("/viewBookingByClass"),     // query param : view by train Class
    delBookingId("/deleteBookingById/{bookingId}"); // path param : delete by id

    private String resource;

    public String getResource() {
        return resource;
    }

    Resource(String resource) {
        this.resource = resource;
    }
}
