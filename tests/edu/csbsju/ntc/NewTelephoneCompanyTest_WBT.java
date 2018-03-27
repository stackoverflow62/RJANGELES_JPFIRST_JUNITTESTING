package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;
	
	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();
	}
	
	@Test
	  public void testGetHours() {
	    int expResult = 0;
	    int result = ntc.getStartTime();
	    assertEquals("Hours is " + expResult,expResult, result);
	  }
	  
	  @Test
	  public void testSetHours() {
	    int expResult = 40;
	    ntc.setStartTime(expResult);
	    int result = ntc.getStartTime();
	    assertEquals("Hours is now " + expResult,expResult, result);
	  }
	  
	  @Test
	  public void testGetDuration() {
	    int expResult = 0;
	    int result = ntc.getDuration();
	    assertEquals("Length is" + expResult,expResult, result);
	  }
	  
	  @Test
	  public void testSetDuration() {
	    int expResult = 40;
	    ntc.setDuration(expResult);
	    int result = ntc.getDuration();
	    assertEquals("Length is now " + expResult,expResult, result);
	  }
	  
	  @Test(expected=UnsupportedOperationException.class)
	  public void testComputeCharge_InvalidStartTime() {
	    ntc.setStartTime(2544);
	    ntc.setDuration(10);
	    ntc.computeCharge();
	  }

	  @Test
	  public void testComputeCharge_StartTimeDiscount() {
	    ntc.setStartTime(759);
	    ntc.setDuration(1);
	    double expResult = 20.8;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    ntc.setStartTime(1800);
	    ntc.setDuration(10);
	    expResult = 208.00;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(1801);
	    ntc.setDuration(10);
	    expResult = 208.00;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	    ntc.setStartTime(1359);
	    ntc.setDuration(10);
	    expResult = 416.00;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());  
	 
	  }

	  @Test
	  public void testComputeCharge_BothDiscounts() {
	    ntc.setStartTime(500);
	    ntc.setDuration(100);
	    double expResult = 1768.0;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	    ntc.setStartTime(759);
	    ntc.setDuration(61);
	    expResult = 1078.48 ;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge()); 
	  }
	  
	  @Test
	  public void testComputeCharge_DurationDiscount() {
	    ntc.setStartTime(900);
	    ntc.setDuration(61);
	    double expResult = 2156.96;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	  } 
	  
}
