package wei.tong.airticket.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.cc.airline.ticketing.SeatingPlan; 

public class SeatingPlanTest {

	@Before
	public void setUp() throws Exception {
		System.out.println( 
				"Starting test of the SeatingPlan default constructor");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println( 
				"Test of the SeatingPlan default constructor complete");
	}

	@Test
	public void testSeatingPlan() {
		SeatingPlan sp = new SeatingPlan(); 
		Assert.assertNotNull(sp); 
		Assert.assertEquals(sp.getSeats().size(), 14); 
		Assert.assertNotNull(sp.getSeatReserver()); 
	}

}
