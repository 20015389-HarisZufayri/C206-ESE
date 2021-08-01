
public class Designer extends User {
	private String username;
	private String password;
	
	public Designer(String name, String number, String email, String role) {
		super(name, number, email, role);
		this.username = "RA"+name;
		this.password = "DA-Pass";
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	
}
