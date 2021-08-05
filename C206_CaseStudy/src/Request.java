/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * haris, 4 Aug 2021 5:59:45 pm
 */

/**
 * @author muhdh
 *
 */
public class Request {
	private int requestID;
	private String propertyType;
	private int areaSize;
	private String requestName;
	private String CNumber;
	private String email;
	private String budget;
	private String tgtCompletionDate;
	private String renovationType;
	private int noOfRooms;
	private int noOfToilets;
	private String renoStyle;
	private boolean CheckUrgent;
	private String requestDate;
	private String status;

	// constructor with Renovation Style
	public Request(int requestID, String propertyType, int areaSize, String requestName, String cNumber, String email,
			String budget, String tgtCompletionDate, String renovationType, int noOfRooms, int noOfToilets,
			String renoStyle, String status, String requestDate) {
		this.requestID = requestID;
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.requestName = requestName;
		this.CNumber = cNumber;
		this.email = email;
		this.budget = budget;
		this.tgtCompletionDate = tgtCompletionDate;
		this.renovationType = renovationType;
		this.noOfRooms = noOfRooms;
		this.noOfToilets = noOfToilets;
		this.renoStyle = renoStyle;
		this.status = status;
		this.requestDate = requestDate;
	}

	// constructor without Renovation Style

	public Request(int requestID, String propertyType, int areaSize, String requestName, String cNumber, String email,
			String budget, String tgtCompletionDate, String renovationType, int noOfRooms, int noOfToilets, String status,
			String requestDate) {
		this.requestID = requestID;
		this.propertyType = propertyType;
		this.areaSize = areaSize;
		this.requestName = requestName;
		this.CNumber = cNumber;
		this.email = email;
		this.budget = budget;
		this.tgtCompletionDate = tgtCompletionDate;
		this.renovationType = renovationType;
		this.noOfRooms = noOfRooms;
		this.noOfToilets = noOfToilets;
		this.status = status;
		this.requestDate = requestDate;
	}

	/**
	 * @return the requestID
	 */

	public int getRequestID() {
		return requestID;
	}

	/**
	 * @return the propertyType
	 */
	public String getPropertyType() {
		return propertyType;
	}

	/**
	 * @return the areaSize
	 */
	public int getAreaSize() {
		return areaSize;
	}

	/**
	 * @return the requestID
	 */
	public String getRequestName() {
		return requestName;
	}

	/**
	 * @return the CNumber
	 */
	public String getCNumber() {
		return CNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the budget
	 */
	public String getBudget() {
		return budget;
	}

	/**
	 * @return the tgtCompletionDate
	 */
	public String getTgtCompletionDate() {
		return tgtCompletionDate;
	}

	/**
	 * @return the renovationType
	 */
	public String getRenovationType() {
		return renovationType;
	}

	/**
	 * @return the noOfRooms
	 */
	public int getNoOfRooms() {
		return noOfRooms;
	}

	/**
	 * @return the noOfToilets
	 */
	public int getNoOfToilets() {
		return noOfToilets;
	}

	/**
	 * @return the renoStyle
	 */
	public String getRenoStyle() {
		return renoStyle;
	}

	/**
	 * @return the requestDate
	 */
	public String getRequestDate() {
		return requestDate;
	}

	public boolean isUrgent() { // WORK IN PROGRESS TO CHECK URGENCY BASED ON MONTH
		int urgency = 0;
		String[] reqSplit = requestDate.split("-");
		String[] tgtSplit = tgtCompletionDate.split("-");
		int reqMth = Integer.parseInt(reqSplit[1]);
		int tgtMth = Integer.parseInt(tgtSplit[1]);

		urgency = tgtMth - reqMth;
		// date format would be DD-MM-YYYY, check if tgtMM
		// - reqMM is 3 or less
		if (urgency <= 3) {

			return true;
		} else {
			return false;
		}

	}

	/**
	 * @return the status
	 */

	public String getStatus() {
		return status;
	}

	/**
	 * @set the status depending on urgency check
	 */

	public void setStatus(String status) {
		if (isUrgent()) {
			status = "Urgent";

		} else {
			status = "";
		}
	}

	public String doStringRequest() {
		return String.format("%-10d %-13s %-10d %-12s %-14s %-13s %-10s %-22s %-15s %-15d %-17d %-16s %-12s %-10s\n",
				getRequestID(), getPropertyType(), getAreaSize(), getRequestName(), getCNumber(), getEmail(), getBudget(),
				getTgtCompletionDate(), getRenovationType(), getNoOfRooms(), getNoOfToilets(), getRenoStyle(),
				getRequestDate(), getStatus());

	}

}
