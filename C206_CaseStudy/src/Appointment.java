
public class Appointment {
	private String custName;
	private String date;
	private int time;
	private String designer;
	private String address;
	
	public Appointment(String custName, String date, int time, String designer, String address) {
		this.custName = custName;
		this.date = date;
		this.time = time;
		this.designer = designer;
		this.address = address;
	}

	public String getCustName() {
		return custName;
	}

	public String getDate() {
		return date;
	}

	public int getTime() {
		return time;
	}

	public String getDesigner() {
		return designer;
	}

	public String getAddress() {
		return address;
	}
}
