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
	
	private int requestID;
	private int quotationID;
	private String renoCat;
	private String renoDes;
	private String dName;
	private String eDate;
	private double totalAmount;
	/**
	 * @param requestID
	 * @param quotationID
	 * @param renoCat
	 * @param renoDes
	 * @param renoPrice
	 * @param dName
	 * @param eDate
	 * @param totalAmount
	 */
	public Quote(int requestID, int quotationID, String renoCat, String renoDes, String dName,
			String eDate, double totalAmount) {
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
	public int getRequestID() {
		return requestID;
	}
	/**
	 * @return the quotationID
	 */
	public int getQuotationID() {
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
	public double getTotalAmount() {
		return totalAmount;
	}

	public String doStringQuote() {
		return String.format("%-10d %-10d %-10s %-10s %-10s %-10s %-10.2f\n", getRequestID(), getQuotationID(), getRenoCat(), 
				getRenoDes(), getdName(), geteDate(), getTotalAmount());

	}

}
