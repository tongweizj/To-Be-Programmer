package wei.tong.airticket.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cc.airline.passengers.Passenger;
import com.cc.airline.passengers.PassengerName;
import com.cc.airline.ticketing.Seat;
import com.cc.airline.ticketing.Ticket;

public class TicketTest {

	@Before
	public void setUp() throws Exception {
		System.out.println(
				"Starting test of the Ticket default constructor");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println( 
				"Test of the Ticket default constructor complete");
	
	}

	@Test
	public void testTicket() {
		//Passenger passenger = new Passenger();
		Passenger passenger = new Passenger(
				new PassengerName("Mary", "I", "Worth"));
		Seat seat = new Seat();
		seat.setRow(1);
		seat.setLetter('L');
		double price = 1000.00;
		Ticket ticket = new Ticket(passenger, seat, price);
		
		Assert.assertTrue(ticket.getTicketNo() > 1000000);
	}
	
	@Test(expected=Exception.class)
	public void testTicketBad() {
		Ticket ticket = new Ticket(null, new Seat(), -100);
		Assert.assertTrue(ticket.getTicketNo() > 1000000);
	}
	// java.lang.AssertionError: Expected exception: java.lang.Exception

}
