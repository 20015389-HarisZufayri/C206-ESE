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
	
	private Quote q1;
	private Quote q2;
	
	private Package p1;
	private Package p2;
	
	private ArrayList<User> userList;
	private ArrayList<Appointment> appList;
	private ArrayList<Quote> quoteList;
	private ArrayList<Package> packageList;
	
	 
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
		
		q1 = new Quote("5", "5","Kitchen","Tiles - $3000", "Kuro", "12-08-2021", "3000.00");
		q2 = new Quote("7", "7","Bedroom","Windows - $2000", "Kyo", "04-09-2021", "2000.00");
		
		p1 = new Package("K100" , "Fragile", "14-8-2021", "16-8-2021", 3);
		p2 = new Package("I200" , "Sturdy", "21-8-2021", "25-8-2021", 8);
		

		userList = new ArrayList<User>();
		appList = new ArrayList<Appointment>();
		quoteList = new ArrayList<Quote>();
		packageList = new ArrayList<Package>();
	}

	@After
	public void tearDown() throws Exception {
		
		c1 = null;
		c2 = null;
		d1 = null;
		d2 = null;
		userList = null;
		appList = null;
		quoteList = null;
	}

	@Test
	public void addUserTest() { //Done by: Yolanda
		
		assertNotNull(userList);

		C206_CaseStudy.addUser(userList, c1);
		assertEquals(1, userList.size());
		assertSame(c1, userList.get(0));

		C206_CaseStudy.addUser(userList, d2);
		assertEquals(2, userList.size());
		assertSame(d2, userList.get(1));
	}
	
	
	@Test
	public void retrieveAllCustomerTest() { //Done by: Yolanda
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
	public void retrieveAllDesignerTest() { //Done by: Yolanda
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
	public void deleteUserTest() { //Done by: Yolanda
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
	public void addAppTest() { //Done by: Yolanda
		
		assertNotNull(appList);

		C206_CaseStudy.addApp(appList, a1);
		assertEquals(1, appList.size());
		assertSame(a1, appList.get(0));

		C206_CaseStudy.addApp(appList, a2);
		assertEquals(2, appList.size());
		assertSame(a2, appList.get(1));
	}
	
	
	@Test
	public void retrieveAllAppTest() { //Done by: Yolanda
		assertNotNull(appList);
		
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
	public void deleteAppTest() { //Done by: Yolanda
		assertNotNull(appList);
		
		C206_CaseStudy.addApp(appList, a1);
		C206_CaseStudy.addApp(appList, a2);
		
		C206_CaseStudy.deleteApp(appList, a1);
		assertEquals(1,appList.size());
		
		C206_CaseStudy.deleteApp(appList, a2);
		assertEquals(0,appList.size());
		
		boolean test = (appList.remove(a1));
		assertFalse(test);
		
	}
	
	
	@Test
	public void addQuoteTest() { //Done by: Rx
		
		assertNotNull(quoteList);

		C206_CaseStudy.addQuote(quoteList, q1);
		assertEquals(1, quoteList.size());
		assertSame(q1, quoteList.get(0));

		C206_CaseStudy.addQuote(quoteList, q2);
		assertEquals(2, quoteList.size());
		assertSame(q2, quoteList.get(1));
	}
	
	@Test
	public void retrieveAllQuoteTest() { //Done by: Rx
		assertNotNull(quoteList);
		
		String allQuote= C206_CaseStudy.retrieveAllQuote(quoteList);
		String testOutput = "";
		assertEquals(testOutput, allQuote);
		
		C206_CaseStudy.addQuote(quoteList, q1);
		C206_CaseStudy.addQuote(quoteList, q2);
		assertEquals(2, quoteList.size());
		
		allQuote= C206_CaseStudy.retrieveAllQuote(quoteList);
		testOutput = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %s\n","5", "5","Kitchen","Tiles - $3000", "Kuro", "12-08-2021", "3000.00");
		testOutput += String.format("%-15s %-15s %-15s %-15s %-15s %-15s %s\n","7", "7","Bedroom","Windows - $2000", "Kyo", "04-09-2021", "2000.00");
	
		assertEquals(testOutput, allQuote);
		
	}
	
	@Test
	public void deleteQuoteTest() { //Done by: Rx
		assertNotNull(quoteList);
		
		C206_CaseStudy.addQuote(quoteList, q1);
		C206_CaseStudy.addQuote(quoteList, q2);
		
		C206_CaseStudy.deleteQuote(quoteList, q1);
		assertEquals(1,quoteList.size());
		
		C206_CaseStudy.deleteQuote(quoteList, q2);
		assertEquals(0,quoteList.size());
		
		boolean test = (quoteList.remove(q1));
		assertFalse(test);
		
	}
	
	@Test
	public void addPackageTest() {//T
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals(1, packageList.size());
		assertSame(p1, packageList.get(0));

		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals(2, packageList.size());
		assertSame(p2, packageList.get(1));
	}
	
	@Test
	public void retrieveAllPackageTest() { //T
		assertNotNull(packageList);
		
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals(testOutput, allPackage);
		
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals(2, packageList.size());
		
		allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10s %-10s %-10s %-10s %-10d\n","K100" , "Fragile", "14-8-2021", "16-8-2021", 3);
		testOutput += String.format("%-10s %-10s %-10s %-10s %-10d\n","I200" , "Sturdy", "21-8-2021", "25-8-2021", 8);
	
		assertEquals(testOutput, allPackage);
		
	}
	@Test
	public void deletePackageTest() { //T
		assertNotNull(packageList);
		
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		
		C206_CaseStudy.deletePackage(packageList, p1);
		assertEquals(1,packageList.size());
		
		C206_CaseStudy.deletePackage(packageList, p2);
		assertEquals(0,packageList.size());
		
		boolean test = (packageList.remove(p1));
		assertFalse(test);
		
	}
	
	
}
