
public class Customer extends User {
	private String username;
	private String password;
	private String Status;
	
	public Customer(String name, String number, String email, String role) {
		super(name, number, email, role);
		this.username = "RA"+name;
		this.password = "RA-Pass";
		this.Status = "New";
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getStatus() {
		return Status;
	}
	
	
}
