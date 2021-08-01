import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Customer c1;
	private Customer c2;
	private Designer d1;
	private Designer d2;
	
	private Appointment a1;
	private Appointment a2;
	
	private ArrayList<User> userList;
	private ArrayList<Appointment> appList;
	 
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		c1 = new Customer("Shino", "9395-9352", "shino@gmail.com", "Customer");
		c2 = new Customer("Mizuki", "9502-4952", "mizu876@gmail.com", "Customer");
		
		d1 = new Designer("Kuro","9395-9312","kuroRA@gmail.com","Designer");
		d2 = new Designer("Kyo","9569-4922","kyoRA@gmail.com","Designer");
		
		a1 = new Appointment("Mizuki","2021-05-02",1500,"Kuro","WhateverThisPlaceIs");
		a2 = new Appointment("Shino","2021-05-06",1500,"Kuro","Area 69");

		userList = new ArrayList<User>();
		appList = new ArrayList<Appointment>();
	}

	@After
	public void tearDown() throws Exception {
		
		c1 = null;
		c2 = null;
		d1 = null;
		d2 = null;
		userList = null;
		appList = null;
	}

	@Test
	public void addUserTest() {
		
		assertNotNull(userList);

		C206_CaseStudy.addUser(userList, c1);
		assertEquals(1, userList.size());
		assertSame(c1, userList.get(0));

		C206_CaseStudy.addUser(userList, d2);
		assertEquals(2, userList.size());
		assertSame(d2, userList.get(1));
	}
	
	
	@Test
	public void retrieveAllCustomerTest() {
		assertNotNull(userList);
		
		String allCustomer= C206_CaseStudy.retrieveAllCustomer(userList);
		String testOutput = "";
		assertEquals(testOutput, allCustomer);
		
		C206_CaseStudy.addUser(userList, c1);
		C206_CaseStudy.addUser(userList, d1);
		assertEquals(2, userList.size());
		
		//Should only have 1 Customer the other being designer
		allCustomer= C206_CaseStudy.retrieveAllCustomer(userList);
		testOutput = String.format("%-10s %-10s %-20s %s\n","Shino", "9395-9352", "shino@gmail.com", "New");
	
		assertEquals("Test that ViewAllCamcorderlist", testOutput, allCustomer);
		
	}
	
	@Test
	public void retrieveAllDesignerTest() {
		assertNotNull(userList);
		
		String allDesigner= C206_CaseStudy.retrieveAllDesigner(userList);
		String testOutput = "";
		assertEquals(testOutput, allDesigner);
		
		C206_CaseStudy.addUser(userList, c1);
		C206_CaseStudy.addUser(userList, d1);
		assertEquals(2, userList.size());
		
		//Should only have 1 Designer the other being Customer
		allDesigner= C206_CaseStudy.retrieveAllDesigner(userList);
		testOutput = String.format("%-10s %-10s %-20s\n","Kuro", "9395-9312", "kuroRA@gmail.com");
	
		assertEquals(testOutput, allDesigner);
		
	}
	
	@Test
	public void deleteUserTest() {
		assertNotNull(userList);
		
		C206_CaseStudy.addUser(userList, c1);
		C206_CaseStudy.addUser(userList, d1);
		C206_CaseStudy.deleteUser(userList, c1);
		assertEquals(1,userList.size());
		
		C206_CaseStudy.deleteUser(userList, d1);
		assertEquals(0,userList.size());
		
		boolean test = (userList.remove(c1));
		assertFalse(test);
		
	}
	
	@Test
	public void addAppTest() {
		
		assertNotNull(appList);

		C206_CaseStudy.addApp(appList, a1);
		assertEquals(1, appList.size());
		assertSame(a1, appList.get(0));

		C206_CaseStudy.addApp(appList, a2);
		assertEquals(2, appList.size());
		assertSame(a2, appList.get(1));
	}
	
	
	@Test
	public void retrieveAllAppTest() {
		assertNotNull(appList);
		
		C206_CaseStudy.addUser(userList, c1);
		C206_CaseStudy.addUser(userList, c2);
		
		String allApp= C206_CaseStudy.retrieveAllAppointment(appList);
		String testOutput = "";
		assertEquals(testOutput, allApp);
		
		C206_CaseStudy.addApp(appList, a1);
		C206_CaseStudy.addApp(appList, a2);
		assertEquals(2, appList.size());
		
		allApp= C206_CaseStudy.retrieveAllAppointment(appList);
		testOutput = String.format("%-10s %-10s %-10d %-10s %s\n","Mizuki","2021-05-02",1500,"Kuro","WhateverThisPlaceIs");
		testOutput += String.format("%-10s %-10s %-10d %-10s %s\n","Shino","2021-05-06",1500,"Kuro","Area 69");
	
		assertEquals(testOutput, allApp);
		
	}
	
	@Test
	public void deleteAppTest() {
		assertNotNull(userList);
		
		C206_CaseStudy.addUser(userList, c1);
		C206_CaseStudy.addUser(userList, c2);
		
		C206_CaseStudy.addApp(appList, a1);
		C206_CaseStudy.addApp(appList, a2);
		
		C206_CaseStudy.deleteApp(appList, a1);
		assertEquals(1,appList.size());
		
		C206_CaseStudy.deleteApp(appList, a2);
		assertEquals(0,appList.size());
		
		boolean test = (appList.remove(a1));
		assertFalse(test);
		
	}

}
