/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * ruiixiiang, 4 Aug 2021 3:27:01 pm
 */

/**
 * @author ruiixiiang
 *
 */
public class Quote {
	
	private String requestID;
	private String quotationID;
	private String renoCat;
	private String renoDes;
	private String dName;
	private String eDate;
	private String totalAmount;
	
			/**
	 * @param requestID
	 * @param quotationID
	 * @param renoCat
	 * @param renoDes
	 * @param dName
	 * @param eDate
	 * @param totalAmount
	 */
	public Quote(String requestID, String quotationID, String renoCat, String renoDes, String dName, String eDate,
			String totalAmount) {
		this.requestID = requestID;
		this.quotationID = quotationID;
		this.renoCat = renoCat;
		this.renoDes = renoDes;
		this.dName = dName;
		this.eDate = eDate;
		this.totalAmount = totalAmount;
	}
			/**
	 * @return the requestID
	 */
	public String getRequestID() {
		return requestID;
	}
	/**
	 * @return the quotationID
	 */
	public String getQuotationID() {
		return quotationID;
	}
	/**
	 * @return the renoCat
	 */
	public String getRenoCat() {
		return renoCat;
	}
	/**
	 * @return the renoDes
	 */
	public String getRenoDes() {
		return renoDes;
	}
	/**
	 * @return the dName
	 */
	public String getdName() {
		return dName;
	}
	/**
	 * @return the eDate
	 */
	public String geteDate() {
		return eDate;
	}
	/**
	 * @return the totalAmount
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	public String doStringQuote() {
		return String.format("%-15s %-15s %-15s %-15s %-15s %-15s %s\n", getRequestID(), getQuotationID(), getRenoCat(), 
				getRenoDes(), getdName(), geteDate(), getTotalAmount());

	}

}
