import java.time.LocalDateTime;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20048254 Tristen Nyam, Aug 4, 2021 3:10:01 PM
 */

public class Package {
	private String packagecode;
	private String packageDesc;
	private String packageStart;
	private String packageEnd;
	private int packageAmt;
	/**
	 * @param packagecode
	 * @param packageDesc
	 * @param packageStart
	 * @param packageEnd
	 * @param packageAmt
	 */
	public Package(String packagecode, String packageDesc, String packageStart, String packageEnd,
			int packageAmt) {
		this.packagecode = packagecode;
		this.packageDesc = packageDesc;
		this.packageStart = packageStart;
		this.packageEnd = packageEnd;
		this.packageAmt = packageAmt;
	}
	/**
	 * @return the packagecode
	 */
	public String getPackagecode() {
		return packagecode;
	}
	/**
	 * @return the packageDesc
	 */
	public String getPackageDesc() {
		return packageDesc;
	}
	/**
	 * @return the packageStart
	 */
	public String getPackageStart() {
		return packageStart;
	}
	/**
	 * @return the packageEnd
	 */
	public String getPackageEnd() {
		return packageEnd;
	}
	/**
	 * @return the packageAmt
	 */
	public int getPackageAmt() {
		return packageAmt;
	}
	public String doStringPackage() {
		return String.format("%-10s %-10s %-10s %-10s %-10d\n", getPackagecode(), getPackageDesc(), getPackageStart(),
		getPackageEnd(), getPackageAmt());
	}
	
	//test
}
