package JPL.java.entities;

public class Certificate {
	private String certificatedID;
	private String certificateName;
	private String certificateRank;
	private String certificateDate;

	public Certificate(String certificatedID, String certificateName, String certificateRank, String certificateDate) {
		super();
		this.certificatedID = certificatedID;
		this.certificateName = certificateName;
		this.certificateRank = certificateRank;
		this.certificateDate = certificateDate;
	}

	public String getCertificatedID() {
		return certificatedID;
	}

	public void setCertificatedID(String certificatedID) {
		this.certificatedID = certificatedID;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getCertificateRank() {
		return certificateRank;
	}

	public void setCertificateRank(String certificateRank) {
		this.certificateRank = certificateRank;
	}

	public String getCertificateDate() {
		return certificateDate;
	}

	public void setCertificateDate(String certificateDate) {
		this.certificateDate = certificateDate;
	}

	@Override
	public String toString() {
		return "Certificate [certificatedID=" + certificatedID + ", certificateName=" + certificateName
				+ ", certificateRank=" + certificateRank + ", certificateDate=" + certificateDate + "]";
	}

}
