package wei.tong.airticket.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cc.airline.passengers.Passenger;
import com.cc.airline.passengers.PassengerName;
import com.cc.airline.passengers.StaffPassenger;
import com.cc.airline.ticketing.Seat;
import com.cc.airline.ticketing.SeatingClass;
import com.cc.airline.ticketing.Ticket;

public class SellTicketTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println( 
				"Starting test of the SellTicket default constructor");
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println( 
				"Test of the SellTicket default constructor complete");
	}
	
	@Test 
	public void sellTicket1() { 
		SeatingClass sClass = SeatingClass.ECONOMY; 
		Passenger passenger = new Passenger( 
				new PassengerName("Mary", "I", "Worth")); 
		Seat seat = new Seat(); 
		seat.setRow(3); 
		seat.setLetter('D'); 
		double price = sClass.getPrice(); 
		
		Ticket ticket = new Ticket(passenger, seat, price); 
		
		System.out.println("Normal ECONOMY Ticket issued: " + ticket); 
		Assert.assertEquals(ticket.getPrice(), 500.0, 0.005 ); 
	} 
	@Test 
	public void sellTicket2() { 
		// testing employee
		SeatingClass sClass = SeatingClass.ECONOMY; 
		PassengerName pName = new PassengerName("Mary", "I", "Worth"); 
		StaffPassenger passenger = new StaffPassenger(pName, "EMP123");
		Seat seat = new Seat(); 
		seat.setRow(sClass.getRows()); 
		seat.setLetter('D'); 
		double price = passenger.disountPrice(sClass.getPrice()); 
		Ticket ticket = new Ticket(passenger, seat, price); 
		
		System.out.println("Staff Passenger Ticket issued: " + ticket); 
		Assert.assertEquals(ticket.getPrice(), 250.0, 0.005 ); 
	} 

	@Test 
	public void sellTicket3() { 
		// testing employee to buy business ticket
		SeatingClass sClass = SeatingClass.BUSINESS;
		PassengerName pName = new PassengerName("Mary", "I", "Worth"); 
		StaffPassenger passenger = new StaffPassenger(pName, "EMP123");
		Seat seat = new Seat(); 
		seat.setRow(sClass.getRows()); 
		seat.setLetter('D'); 
		double price = passenger.disountPrice(sClass.getPrice()); 
		Ticket ticket = new Ticket(passenger, seat, price); 
		
		System.out.println("Staff Passenger Ticket issued: " + ticket); 
		Assert.assertEquals(ticket.getPrice(), 750.0, 0.005 ); 
	} 
	// class: StaffPassenger, method:disountPrice
	// failure reason: this method does not check which type of ticket staff want to buy, 
	// just give all 50% discount
}
