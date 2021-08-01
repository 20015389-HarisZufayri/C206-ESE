
public class User {
	private String name;
	private String number;
	private String email;
	private String role;
	
	public User(String name, String number, String email, String role) {
		this.name = name;
		this.number = number;
		this.email = email;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
	
	public String doString() {
		return String.format("%-10s %-10s %-20s", getName(), getNumber(),getEmail());
	}
}
