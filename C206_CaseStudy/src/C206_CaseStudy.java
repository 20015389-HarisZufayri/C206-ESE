import java.util.*;
import java.text.*;
import java.util.regex.Pattern;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;

	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Appointment> appList = new ArrayList<Appointment>();
	private static ArrayList<Quote> quoteList = new ArrayList<Quote>();
	private static ArrayList<Request> requestList = new ArrayList<Request>();
	private static ArrayList<Package> packageList = new ArrayList<Package>();

	private static Date CURRENT_DATE = new Date();
	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-mm-yyyy");
	private static String cDATE = DATE_FORMAT.format(CURRENT_DATE);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userList.add(new Customer("Shino", "9395-9352", "shino@gmail.com", "Customer"));
		userList.add(new Designer("Kuro", "9395-9312", "kuroRA@gmail.com", "Designer"));

		userList.add(new Customer("Yolanda", "9395-123", "yolanda@gmail.com", "Customer"));

		appList.add(new Appointment("Shino", "06-05-2021", 1500, "Kuro", "River Valley 2510"));

		quoteList.add(new Quote("1", "1", "Kitchen", "Tiles - $3000", "Kuro", "12-08-2021", "3000.00"));
		packageList.add(new Package("W100", "Fragile", "12-8-2021", "16-8-2021", 5));
		requestList.add(new Request(7, "HDB", 999, "ReqOne", "9395-9352", "haris@gmail.com", "9999.99", "23-08-2021",
				"Room", 3, 2, "Gothic", "Urgent", "18-07-2020"));

		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Manage User
				C206_CaseStudy.manageUser();

			} else if (option == 2) {
				// Manage Package
				C206_CaseStudy.managePackage();

			} else if (option == 3) {
				// Manage Request for quotation
				C206_CaseStudy.manageRequest();

			} else if (option == 4) {
				// Manage Quotation
				C206_CaseStudy.manageQuote();

			} else if (option == 5) {
				// Manage Appointment
				C206_CaseStudy.manageApp();

			} else if (option == 6) {
				System.out.println("Logging off. . .");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("RENOVATION ACE");
		System.out.println("1. Manage User");
		System.out.println("2. Manage Package");
		System.out.println("3. Manage Request for Quotation");
		System.out.println("4. Manage Quotation");
		System.out.println("5. Manage Appointment");
		System.out.println("6. Logout");
		Helper.line(80, "-");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// Manage Request Menu by Haris
	public static void manageRequest() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("MANAGE REQUEST");
		System.out.println("1. Add New Request");
		System.out.println("2. View All Request");
		System.out.println("3. Delete Request");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int Choice = Helper.readInt("Enter an option > ");

		if (Choice == 1) {
			Request r1 = inputRequest();
			C206_CaseStudy.addRequest(requestList, r1);
			manageRequest();
		} else if (Choice == 2) {
			C206_CaseStudy.viewAllRequest(requestList);
			manageRequest();
		} else if (Choice == 3) {
			Request r1 = C206_CaseStudy.inputDeleteRequest();
			C206_CaseStudy.deleteRequest(requestList, r1);
			manageRequest();
		} else if (Choice == 4) {
			C206_CaseStudy.menu();
			manageRequest();
		} else if (Choice > 4 || Choice < 0) {
			System.out.println("Invalid option");
			C206_CaseStudy.menu();

		}

	}

	// Manage Delete Requests by Haris
	public static void deleteRequest(ArrayList<Request> requestList, Request r1) {
		// TODO Auto-generated method stub
		if (r1 != null && requestList.remove(r1)) {
			System.out.println("Request successfully deleted");
		} else {
			System.out.println("Invalid request for deletion");
		}

	}

	// Manage Input Delete Request Requests by Haris
	public static Request inputDeleteRequest() {
		// TODO Auto-generated method stub
		Request r1 = null;
		if (requestList.size() != 0) {
			int requestid = Helper.readInt("Enter Request ID > ");
			for (Request r : requestList) {
				if (r.getRequestID() == (requestid)) {
					r1 = r;

				}
			}
		} else {
			System.out.println("There are no quotes");
		}
		return r1;

	}

	// Manage View All Requests by Haris
	public static void viewAllRequest(ArrayList<Request> requestList) {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("REQUEST LIST");
		String output = String.format(
				"%-10s %-10s %-10s %-10s %-10s %-15s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "REQUEST-ID",
				"PROPERTY-TYPE", "AREA-SIZE", "REQUEST-NAME", "CONTACT-NUMBER", "EMAIL", "BUDGET",
				"TARGET-COMPLETION-DATE", "RENOVATION-TYPE", "NUMBER-OF-ROOMS", "NUMBER-OF-TOILETS", "RENOVATION-STYLE",
				"REQUEST-DATE", "STATUS");
		output += retrieveAllRequest(requestList);
		System.out.println(output);

	}

// Manage Retrieve Requests by Haris
	public static String retrieveAllRequest(ArrayList<Request> requestList) {
		// TODO Auto-generated method stub
		String output = "";

		for (Request r : requestList) {
			output += String.format("%s", r.doStringRequest());
		}
		return output;

	}

	// Add Request into requestList by Haris
	public static void addRequest(ArrayList<Request> requestList, Request r1) {
		// TODO Auto-generated method stub

		if (r1 != null && requestList.add(r1)) {
			System.out.println("Request successfully added");
		}

	}

	// Manage Input Request by Haris
		public static Request inputRequest() {
			// TODO Auto-generated method stub
			Request r1 = null;

			int requestid = Helper.readInt("Enter Request ID > ");
			boolean requestidCheck = validInput("Request ID", String.valueOf(requestid));
			while (requestidCheck != true) {
				requestid = Helper.readInt("Enter Request ID > ");
				requestidCheck = validInput("Request ID", String.valueOf(requestid));
			}
			// System.out.println(requestidCheck);

			String propertyType = Helper.readString("Enter Property Type [HDB|Private|Landed] > ");
			boolean propertyTypeCheck = validInput("Property Type", propertyType);
			while (propertyTypeCheck != true) {
				propertyType = Helper.readString("Enter Property Type [HDB|Private|Landed] > ");
				propertyTypeCheck = validInput("Property Type", propertyType);
			}

			// System.out.println(propertyTypeCheck);

			int areaSize = Helper.readInt("Enter Area Size > ");
			boolean areaSizeCheck = validInput("Area Size", String.valueOf(areaSize));
			while (areaSizeCheck != true) {
				areaSize = Helper.readInt("Enter Area Size > ");
				areaSizeCheck = validInput("Area Size", String.valueOf(areaSize));
			}
			// System.out.println(areaSizeCheck);

			String requestName = Helper.readString("Enter Request Name > ");
			boolean requestNameCheck = validInput("Name", requestName);
			while (requestNameCheck != true) {
				requestName = Helper.readString("Enter Request Name > ");
				requestNameCheck = validInput("Name", requestName);
			}
			// System.out.println(requestNameCheck);

			String CNumber = Helper.readString("Enter Contact Number > ");
			boolean CNumberCheck = validInput("Mobile", CNumber);
			while (CNumberCheck != true) {
				CNumber = Helper.readString("Enter Contact Number > ");
				CNumberCheck = validInput("Mobile", CNumber);
			}
			// System.out.println(CNumberCheck);

			String email = Helper.readString("Enter Email > ");
			boolean emailCheck = validInput("Email", email);
			while (emailCheck != true) {
				email = Helper.readString("Enter Email > ");
				emailCheck = validInput("Email", email);
			}
			// System.out.println(emailCheck);

			String budget = Helper.readString("Enter Total Budget Amount > ");
			boolean budgetCheck = validInput("Total Quotation Amount", budget);
			while (budgetCheck != true) {
				budget = Helper.readString("Enter Total Budget Amount > ");
				budgetCheck = validInput("Total Quotation Amount", budget);
			}
			// System.out.println(budgetCheck);

			String tgtCompletionDate = Helper.readString("Enter Completion Date DD-MM-YYYY > ");
			boolean tgtCompletionDateCheck = validInput("Date", tgtCompletionDate);
			while (tgtCompletionDateCheck != true) {
				tgtCompletionDate = Helper.readString("Enter Completion Date DD-MM-YYYY > ");
				tgtCompletionDateCheck = validInput("Date", tgtCompletionDate);
			}
			// System.out.println(tgtCompletionDateCheck);

			String renovationType = Helper.readString("Enter Renovation Type [Whole House|Room|Kitchen|Toilet] > ");
			boolean renovationTypeCheck = validInput("Renovation Type", renovationType);
			while (renovationTypeCheck != true) {
				renovationType = Helper.readString("Enter Renovation Type [Whole House|Room|Kitchen|Toilet] > ");
				renovationTypeCheck = validInput("Renovation Type", renovationType);
			}
			// System.out.println(renovationTypeCheck);

			int noOfRooms = Helper.readInt("Enter number of rooms: ");
			boolean noOfRoomsCheck = validInput("Number of Items", String.valueOf(noOfRooms));
			while (noOfRoomsCheck != true) {
				noOfRooms = Helper.readInt("Enter number of rooms: ");
				noOfRoomsCheck = validInput("Number of Items", String.valueOf(noOfRooms));
			}
			// System.out.println(noOfRoomsCheck);

			int noOfToilets = Helper.readInt("Enter number of toilets: ");
			boolean noOfToiletsCheck = validInput("Number of Items", String.valueOf(noOfToilets));
			while (noOfToiletsCheck != true) {
				noOfToilets = Helper.readInt("Enter number of toilets: ");
				noOfToiletsCheck = validInput("Number of Items", String.valueOf(noOfToilets));
			}
			// System.out.println(noOfToiletsCheck);

			String renoStyle = Helper.readString("Enter renovation style: ");
			boolean renoStyleCheck = validInput("Name", renoStyle);
			while (tgtCompletionDateCheck != true) {
				tgtCompletionDate = Helper.readString("Enter Completion Date DD-MM-YYYY > ");
				tgtCompletionDateCheck = validInput("Date", tgtCompletionDate);
			}
			// System.out.println(renoStyleCheck);

			String status = Helper.readString("Urgent ? :");
			boolean statusCheck = validInput("Status", status);
			while (statusCheck != true) {
				status = Helper.readString("Urgent ? :");
				statusCheck = validInput("Status", status);
			}
			// System.out.println(statusCheck);

			String requestDate = Helper.readString("Enter Request Date: ");
			boolean requestDateCheck = validInput("Date", requestDate);
			while (requestDateCheck != true) {
				requestDate = Helper.readString("Enter Request Date: ");
				requestDateCheck = validInput("Date", requestDate);
			}
			// System.out.println(requestDateCheck);

			// with renoStyle
			if (requestidCheck && propertyTypeCheck && areaSizeCheck && requestNameCheck && CNumberCheck && emailCheck
					&& budgetCheck && tgtCompletionDateCheck && renovationTypeCheck && noOfRoomsCheck && noOfToiletsCheck
					&& renoStyleCheck && statusCheck && requestDateCheck) {
				r1 = new Request(requestid, propertyType, areaSize, requestName, CNumber, email, budget, tgtCompletionDate,
						renovationType, noOfRooms, noOfToilets, renoStyle, status, requestDate);
				// without renoStyle
			} else if (requestidCheck && propertyTypeCheck && areaSizeCheck && requestNameCheck && CNumberCheck
					&& emailCheck && budgetCheck && tgtCompletionDateCheck && renovationTypeCheck && noOfRoomsCheck
					&& noOfToiletsCheck && statusCheck && requestDateCheck) {
				r1 = new Request(requestid, propertyType, areaSize, requestName, CNumber, email, budget, tgtCompletionDate,
						renovationType, noOfRooms, noOfToilets, status, requestDate);
			} else {
				System.out.println("Invalid Input");
			}
			return r1;

		}

	// Manage quote menu by RX
	public static void manageQuote() {
		C206_CaseStudy.setHeader("MANAGE QUOTE");
		System.out.println("1. Add New Quote");
		System.out.println("2. View All Quote");
		System.out.println("3. Delete Quote");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int Choice = Helper.readInt("Enter an option > ");

		if (Choice == 1) {
			Quote q1 = inputQuote();
			C206_CaseStudy.addQuote(quoteList, q1);
			manageQuote();
		} else if (Choice == 2) {
			C206_CaseStudy.viewAllQuote(quoteList);
			manageQuote();
		} else if (Choice == 3) {
			Quote q1 = C206_CaseStudy.inputDeleteQuote();
			C206_CaseStudy.deleteQuote(quoteList, q1);
			manageQuote();
		} else if (Choice == 4) {
			C206_CaseStudy.menu();
			manageQuote();
		} else if (Choice > 4 || Choice < 0) {
			System.out.println("Invalid option");
			C206_CaseStudy.menu();

		}
	}

	/**
	 * @return
	 */
	// Manage quote delete by RX
	public static Quote inputDeleteQuote() {
		Quote q1 = null;
		if (quoteList.size() != 0) {
			String quotationid = Helper.readString("Enter Quotation ID > ");
			for (Quote q : quoteList) {
				if (q.getQuotationID().equals(quotationid)) {
					q1 = q;

				}
			}
		} else {
			System.out.println("There are no quotes");
		}
		return q1;
	}

	public static void deleteQuote(ArrayList<Quote> quoteList, Quote q1) {
		if (q1 != null && quoteList.remove(q1)) {
			System.out.println("User successfully deleted");
		} else {
			System.out.println("Invalid user for deletion");
		}

	}

	// Manage quote add by RX
	public static Quote inputQuote() {

		Quote q1 = null;

		String requestid = Helper.readString("Enter Request ID > ");
		boolean requestidCheck = validInput("Request ID", requestid);
		
//		while(requestidCheck != true) {
//			requestid = Helper.readString("Enter Request ID > ");
//			requestidCheck = validInput("Request ID", requestid) && 
//		}
		
		String quotationid = Helper.readString("Enter Quotation ID > ");
		boolean quotationidCheck = validInput("Quotation ID", quotationid);

		String renoC = Helper.readString("Enter Reno Category [Bedroom|Kitchen|Living Room] > ");
		boolean renoCheck = validInput("Reno Cat", renoC);

		String renoD = Helper.readString("Enter Reno Description > ");
		boolean renoDCheck = validInput("Reno Des", renoD);

		String desName = Helper.readString("Enter Name > ");
		boolean desNameCheck = validInput("Name", desName);

		String earDate = Helper.readString("Enter Date [yyyy-MM-dd] > ");
		boolean earDateCheck = validInput("Date", earDate);

		String tAmount = Helper.readString("Enter Total Quotation Amount [0000.00] > ");
		boolean tAmountCheck = validInput("Total Quotation Amount", tAmount);

		if (requestidCheck && quotationidCheck && renoCheck && renoDCheck && desNameCheck && earDateCheck
				&& tAmountCheck) {
			q1 = new Quote(requestid, quotationid, renoC, renoD, desName, earDate, tAmount);
		} else {
			System.out.println("Invalid Input");
		}
		return q1;
	}

	public static void addQuote(ArrayList<Quote> quoteList, Quote q1) {

		if (q1 != null && quoteList.add(q1)) {
			System.out.println("Quote successfully added");
		}
	}

	// Manage quote view by RX
	public static String retrieveAllQuote(ArrayList<Quote> quoteList) {
		String output = "";

		for (Quote q : quoteList) {
			output += String.format("%s", q.doStringQuote());
		}
		return output;
	}

	public static void viewAllQuote(ArrayList<Quote> quoteList) {
		C206_CaseStudy.setHeader("QUOTATION LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %s\n", "REQUEST ID", "QUOTATION ID",
				"CATEGORY", "DESCRIPTION", "DESIGNER", "EARLIEST DATE", "TOTAL AMOUNT");
		output += retrieveAllQuote(quoteList);
		System.out.println(output);
	}

	// ---<< MANAGE USER MENU >>---// Done by: Yolanda
	public static void manageUser() {
		C206_CaseStudy.setHeader("MANAGE USER");
		System.out.println("1. Add New User");
		System.out.println("2. View All User");
		System.out.println("3. Delete User");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int Choice = Helper.readInt("Enter an option > ");

		if (Choice == 1) {
			User u1 = inputUser();
			C206_CaseStudy.addUser(userList, u1);
		} else if (Choice == 2) {
			C206_CaseStudy.viewAllCustomer(userList);
			C206_CaseStudy.viewAllDesigner(userList);
		} else if (Choice == 3) {
			User u1 = C206_CaseStudy.inputDeleteUser();
			C206_CaseStudy.deleteUser(userList, u1);
		} else if (Choice == 4) {
			C206_CaseStudy.menu();
		} else if (Choice > 4 || Choice < 0) {
			System.out.println("Invalid option");
			C206_CaseStudy.menu();

		}
	}

	// ---<< MANAGE APPOINTMNET MENU >>---// Done by: Yolanda
	public static void manageApp() {
		C206_CaseStudy.setHeader("MANAGE APPOINTMENT");
		System.out.println("1. Add New Appointment");
		System.out.println("2. View All Appointment");
		System.out.println("3. Delete Appointment");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int cApp = Helper.readInt("Enter an option > ");

		if (cApp == 1) {
			Appointment a1 = inputApp();
			C206_CaseStudy.addApp(appList, a1);
		} else if (cApp == 2) {
			C206_CaseStudy.viewAllAppointment(appList);

		} else if (cApp == 3) {
			Appointment a1 = C206_CaseStudy.inputDeleteApp();
			C206_CaseStudy.deleteApp(appList, a1);
		} else if (cApp == 4) {
			C206_CaseStudy.menu();
		} else if (cApp > 4 || cApp < 0) {
			System.out.println("Invalid option");
			C206_CaseStudy.menu();

		}

	}

	// ---<< MANAGE USER: ADD USER >>---// Done by: Yolanda
	public static User inputUser() {
		User u1 = null;

		String name = Helper.readString("Enter name > ");

		if (checkCustomer(name) == false) {

			boolean nameCheck = validInput("Name", name);

			String mobile = Helper.readString("Enter mobile [0000-0000] > ");
			boolean mobileCheck = validInput("Mobile", mobile);

			String email = Helper.readString("Enter email > ");
			boolean emailCheck = validInput("Email", email);

			String role = Helper.readString("Enter role [Customer|Designer] > ");
			boolean roleCheck = validInput("Role", role);

			if (nameCheck && mobileCheck && emailCheck && roleCheck) {
				if (role.equals("Customer") || role.equals("Client")) {
					u1 = new Customer(name, mobile, email, role);

				} else if (role.equalsIgnoreCase("Designer")) {
					u1 = new Designer(name, mobile, email, role);

				}
			} else {
				System.out.println("Invalid input");

			}
		} else {
			System.out.println("User is already registered");
		}

		return u1;

	}

	public static void addUser(ArrayList<User> userList, User u1) {

		if (u1 != null && userList.add(u1)) {
			System.out.println("User successfully added");
		}
	}

	// ---<< MANAGE USER: VIEW CUSTOMER >>---// Done by: Yolanda
	public static String retrieveAllCustomer(ArrayList<User> userList) {
		String output = "";
		for (User u : userList) {
			if (u instanceof Customer) {
				Customer c = (Customer) u;
				output += String.format("%s", c.doString());

			}
		}
		return output;
	}

	public static void viewAllCustomer(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("CLIENT LIST");
		String output = String.format("%-10s %-10s %-20s %-10s\n", "NAME", "NUMBER", "EMAIL", "STATUS");
		output += retrieveAllCustomer(userList);
		System.out.println(output);
	}

	// ---<< MANAGE USER: VIEW DESIGNER >>---// Done by: Yolanda
	public static String retrieveAllDesigner(ArrayList<User> userList) {
		String output = "";

		for (User u : userList) {
			if (u instanceof Designer) {
				Designer d = (Designer) u;
				output += String.format("%s\n", d.doString());

			}
		}
		return output;
	}

	public static void viewAllDesigner(ArrayList<User> userList) {
		C206_CaseStudy.setHeader("DESIGNER LIST");
		String output = String.format("%-10s %-10s %-20s\n", "NAME", "NUMBER", "EMAIL");
		output += retrieveAllDesigner(userList);
		System.out.println(output);
	}

	// ---<< MANAGE USER: DELETE USER >>---// Done by: Yolanda
	public static User inputDeleteUser() {
		User u1 = null;
		if (userList.size() != 0) {
			String name = Helper.readString("Enter name > ");
			for (User u : userList) {
				if (u.getName().equals(name)) {
					u1 = u;

				}
			}
		} else {
			System.out.println("There are no users");
		}
		return u1;
	}

	public static void deleteUser(ArrayList<User> userList, User u1) {
		if (u1 != null && userList.remove(u1)) {
			System.out.println("User successfully deleted");
		} else {
			System.out.println("Invalid user for deletion");
		}

	}

	// ---<< MANAGE APPOINTMENT: ADD APPOINTMENT >>---// Done by: Yolanda
	public static Appointment inputApp() {
		Appointment a1 = null;
		boolean exist = false;
		String name = Helper.readString("Enter Name > ");

		if (checkCustomer(name)) {

			for (Appointment a : appList) {

				if (a.getCustName().equals(name)) {

					System.out.println("User have existing appointment");
					exist = true;

				} else {

					exist = false;
				}
			}

		} else {
			System.out.println("User is not registered");
		}

		if (exist == false) {
			a1 = checkDesiApp(name);
		}
		return a1;
	}

	public static void addApp(ArrayList<Appointment> appList, Appointment a1) {
		if (a1 != null && appList.add(a1)) {
			System.out.println("Appointment successfully added");
		}
	}

	// ---<< MANAGE APPOINTMENT: VIEW APPOINTMENT >>---// Done by: Yolanda
	public static String retrieveAllAppointment(ArrayList<Appointment> appList) {
		String output = "";

		for (Appointment a : appList) {

			output += String.format("%s", a.doString2());

		}
		return output;
	}

	public static void viewAllAppointment(ArrayList<Appointment> appList) {
		C206_CaseStudy.setHeader("APPOINTMENT LIST");
		String output = String.format("%-10s %-10s %-10s %-10s %s\n", "NAME", "DATE", "TIME", "DESIGNER", "ADDRESS");
		output += retrieveAllAppointment(appList);
		System.out.println(output);
	}

	// ---<< MANAGE APPOINTMENT: DELETE APPOINTMENT >>---// Done by: Yolanda
	public static Appointment inputDeleteApp() {

		if (appList.size() != 0) {
			String name = Helper.readString("Enter name > ");
			if (checkCustomer(name)) {
				for (Appointment a : appList) {
					if (a.getCustName().equals(name)) {
						return a;
					}
				}
			} else {
				System.out.println("User is not registered");
			}
		} else {
			System.out.println("There are no appointments");
		}
		return null;
	}

	public static void deleteApp(ArrayList<Appointment> appList, Appointment a1) {
		if (a1 != null && appList.remove(a1)) {
			System.out.println("Appointment successfully deleted");
		}
	}

	// Validate Customer is in system
	private static boolean checkCustomer(String user) {
		boolean check = false;
		for (User u : userList) {
			if (u instanceof Customer) {
				Customer c = (Customer) u;
				if (c.getName().equals(user)) {
					check = true;
					break;
				} else {
					check = false;
				}
			}
		}
		return check;
	}

	private static boolean checkDesigner(String user) {
		boolean check = false;
		for (User u : userList) {
			if (u instanceof Designer) {
				Designer d = (Designer) u;
				if (d.getName().equals(user)) {
					check = true;
					break;
				} else {
					check = false;
				}
			}
		}
		return check;
	}

	// Valid Designer is registered and if they have existing appointment on same
	// input date/time
	public static Appointment checkDesiApp(String name) {

		Appointment a1 = null;

		boolean check = false;

		String address = "";
		String designer = "";
		String date = "";
		String time = "";
		int t2 = 0;

		address = Helper.readString("Enter address > ");
		boolean checkAddress = validInput("Address", address);

		while (checkAddress != true) {
			address = Helper.readString("Enter address > ");
			checkAddress = validInput("Address", address);
		}

		date = Helper.readString("Enter date [dd-mm-yyyy] > ");
		boolean checkDate = validInput("Date", date) && chkCurDate(date);

		while (checkDate != true) {
			date = Helper.readString("Enter date [dd-mm-yyyy] > ");
			checkDate = validInput("Date", date) && chkCurDate(date);
		}

		time = Helper.readString("Enter time [0000] > ");
		boolean checkTime = validInput("Time", time);

		while (checkTime != true) {
			time = Helper.readString("Enter time [0000] > ");
			checkTime = validInput("Time", time);
		}
		t2 = Integer.parseInt(time);

		while (check != true) {
			viewAllDesigner(userList);
			designer = Helper.readString("Enter designer name > ");

			for (User u : userList) {
				if (u.getName().equals(designer)) {
					if (appList.size() != 0) {
						for (Appointment a : appList) {
							if (a.getDesigner().equals(designer) && a.getDate().equals(date) && a.getTime() == t2) {
								// Designer already have existing appointment = Cannot add
								System.out.println("Designer already has an appointment on this date and time");

								// Get user to select a different date and time
								date = Helper.readString("Enter date [dd-mm-yyyy] > ");
								checkDate = validInput("Date", date) && chkCurDate(date);
								while (checkDate != true) {
									date = Helper.readString("Enter date [dd-mm-yyyy] > ");
									checkDate = validInput("Date", date) && chkCurDate(date);
								}

								time = Helper.readString("Enter time [0000] > ");
								checkTime = validInput("Time", time);

								while (checkTime != true) {
									time = Helper.readString("Enter time [0000] > ");
									checkTime = validInput("Time", time);
								}

							} else if (!(a.getDesigner().equals(designer))) {
								// Cannot find designer in appointment list = Can add
								check = true;
								break;

							} else if (a.getDesigner().equals(designer)) {
								// Designer is free = Can add
								check = true;
								break;
							}
						}
					} else {
						// If there are nothing in array = Can add
						check = true;
						break;
					}
				}
			}
			// Create new Appointment object
			if (check == true) {
				a1 = new Appointment(name, date, t2, designer, address);
			} else {
				System.out.println("Invalid designer");
			}
		}
		return a1;
	}

	public static boolean validInput(String type, String input) {
		boolean check = false;
		if (type.equals("Name")) {
			String patternName = "\\D{3,}";
			check = Pattern.matches(patternName, input);
		} else if (type.equals("Mobile")) {
			String patternMobile = "[89]\\d{3}-\\d{4}";
			check = Pattern.matches(patternMobile, input);
		} else if (type.equals("Email")) {
			String patternEmail = "^\\S+@\\S+\\.\\S+$";
			check = Pattern.matches(patternEmail, input);
		} else if (type.equals("Role")) {
			String patternRole = "\\b(Customer\\b|Client\\b|Designer)\\b";
			check = Pattern.matches(patternRole, input);
		} else if (type.equals("Address")) {
			String patternAddress = "\\D{1,}";
			check = Pattern.matches(patternAddress, input);
		} else if (type.equals("Date")) {
			String patternDate = "^(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d$";
			check = Pattern.matches(patternDate, input);
		} else if (type.equals("Time")) {
			String patternTime = "^([01][0-9]|2[0-3])([0-5][0-9])$";
			check = Pattern.matches(patternTime, input);
		} else if (type.equals("Request ID")) {
			String patternRid = "\\d+";
			check = Pattern.matches(patternRid, input);
		} else if (type.equals("Quotation ID")) {
			String patternQid = "\\d+";
			check = Pattern.matches(patternQid, input);
		} else if (type.equals("Total Quotation Amount")) {
			String patternTqo = "^[\\d]+[\\.][\\d]{2}$";
			check = Pattern.matches(patternTqo, input);
		} else if (type.equals("Reno Cat")) {
			String patternRec = "\\b(Bedroom\\b|Kitchen\\b|Living Room)\\b";
			check = Pattern.matches(patternRec, input);
		} else if (type.equals("Reno Des")) {
			String patternRed = ".*";
			check = Pattern.matches(patternRed, input);
		} else if (type.equals("Property Type")) {
			String patternProperty = "\\b(HDB\\b|Private\\b|Landed)\\b";
			check = Pattern.matches(patternProperty, input);
		} else if (type.equals("Area Size")) {
			String patternAreaSize = "^([1-9][0-9]{0,2}|1000)$";
			check = Pattern.matches(patternAreaSize, input);
		} else if (type.equals("Renovation Type")) {
			String patternRenType = "\\b(Whole House\\b|Room\\b|Kitchen\\b|Toilet)\\b";
			check = Pattern.matches(patternRenType, input);
		} else if (type.equals("Number of Items")) {
			String patternNoOfItems = "^[0-9]|[1-9][0-9]";
			check = Pattern.matches(patternNoOfItems, input);
		} else if (type.equals("Status")) {
			String patternStatus = "\\b(Urgent\\b|Okay)\\b";
			check = Pattern.matches(patternStatus, input);
		}
		return check;
	}

	public static boolean chkCurDate(String date) {

		Date appDate;
		Date cDate;
		boolean checked = false;
		try {
			cDate = DATE_FORMAT.parse(cDATE);
			appDate = DATE_FORMAT.parse(date);
			int result = appDate.compareTo(cDate);

			if (result == 0) {
				System.out.println("Date cannot be today");
				checked = false;
			} else if (result > 0) {
				checked = true;
			} else if (result < 0) {
				System.out.println("Invalid date");
				checked = false;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Invalid date");
			checked = false;
		}
		return checked;
	}

	public static void managePackage() { // T
		C206_CaseStudy.setHeader("MANAGE PACKAGE");
		System.out.println("1. Add New Package");
		System.out.println("2. View All Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Back");
		Helper.line(80, "-");

		int Choice = Helper.readInt("Enter an option > ");

		if (Choice == 1) {
			Package p1 = inputPackage();
			C206_CaseStudy.addPackage(packageList, p1);
		} else if (Choice == 2) {
			C206_CaseStudy.viewAllPackage(packageList);
		} else if (Choice == 3) {
			Package p1 = C206_CaseStudy.inputDeletePackage();
			C206_CaseStudy.deletePackage(packageList, p1);
		} else if (Choice == 4) {
			C206_CaseStudy.menu();
		} else if (Choice > 4 || Choice < 0) {
			System.out.println("Invalid option");
			C206_CaseStudy.menu();

		}

	}

	public static Package inputDeletePackage() { // T
		Package p1 = null;
		if (packageList.size() != 0) {
			String packageid = Helper.readString("Enter Package ID > ");
			for (Package p : packageList) {
				if (p.getPackagecode().equals(packageid)) {
					p1 = p;

				}
			}
		} else {
			System.out.println("There are no package");
		}
		return p1;
	}

	public static void addPackage(ArrayList<Package> packageList, Package p1) { // T
		// TODO Auto-generated method stub

		if (p1 != null && packageList.add(p1)) {
			System.out.println("Package successfully added");
		}

	}

	public static Package inputPackage() {// T
		// TODO Auto-generated method stub
		Package p1 = null;

		String packageid = Helper.readString("Enter Package ID > ");
		boolean packageidCheck = validInput("Request ID", packageid);
		System.out.println(packageidCheck);

		String packageDesc = Helper.readString("Enter Package Description > ");
		boolean packageDescCheck = validInput("Package Type", packageDesc);
		System.out.println(packageDescCheck);

		String packageStart = Helper.readString("Enter Start Date > ");
		boolean packageStartCheck = validInput("Date", packageStart);
		System.out.println(packageStartCheck);

		String packageEnd = Helper.readString("Enter End Date > ");
		boolean packageEndCheck = validInput("Date", packageEnd);
		System.out.println(packageEndCheck);

		int amount = Helper.readInt("Enter Total Package Amount > ");
		boolean amountCheck = validInput("Total Package Amount", String.valueOf(amount));
		System.out.println(amountCheck);

		return p1;

	}

	public static void viewAllPackage(ArrayList<Package> packageList) {// T
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("PACKAGE LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-10s\n", "PACKAGE ID", "PACKAGE DESCRIPTION",
				"START DATE", "END DATE", "QUANTITY");
		output += retrieveAllPackage(packageList);
		System.out.println(output);

	}

	public static String retrieveAllPackage(ArrayList<Package> packageList) {// T
		// TODO Auto-generated method stub
		String output = "";

		for (Package p : packageList) {
			output += String.format("%s", p.doStringPackage());
		}
		return output;

	}

	public static void deletePackage(ArrayList<Package> packageList, Package p1) {// T
		// TODO Auto-generated method stub
		if (p1 != null && packageList.remove(p1)) {
			System.out.println("Package successfully deleted");
		} else {
			System.out.println("Invalid package for deletion");
		}

	}

}
