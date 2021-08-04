import java.util.*;
import java.text.*;
import java.util.regex.Pattern;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 6;

	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Appointment> appList = new ArrayList<Appointment>();

	private static Date CURRENT_DATE = new Date();
	private static DateFormat DATE_FORMAT = new SimpleDateFormat("dd-mm-yyyy");
	private static String cDATE = DATE_FORMAT.format(CURRENT_DATE);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userList.add(new Customer("Shino", "9395-9352", "shino@gmail.com", "Customer"));
		userList.add(new Designer("Kuro", "9395-9312", "kuroRA@gmail.com", "Designer"));

		userList.add(new Customer("Yolanda", "9395-123", "yolanda@gmail.com", "Customer"));

		appList.add(new Appointment("Shino", "06-05-2021", 1500, "Kuro", "River Valley 2510"));

		int option = 0;
		while (option != OPTION_QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// Manage User
				C206_CaseStudy.manageUser();

			} else if (option == 2) {
				// Manage Package

			} else if (option == 3) {
				// Manage Request for quotation

			} else if (option == 4) {
				// Manage Quotation

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

		if (checkUser(name) == false) {

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
		
		if (checkUser(name)) {
			
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
			a1 = checkDesigner(name);
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
			if (checkUser(name)) {
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
	private static boolean checkUser(String user) {
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

	// Valid Designer is registered and if they have existing appointment on same
	// input date/time
	public static Appointment checkDesigner(String name) {

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
								
								//Get user to select a different date and time
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
			}
			else {
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
}
