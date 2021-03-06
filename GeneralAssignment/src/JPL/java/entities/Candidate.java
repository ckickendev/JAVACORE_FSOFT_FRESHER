package JPL.java.entities;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;

import JPL.java.dao.CandidateDaoImpl;
import JPL.java.exception.BirthdayException;
import JPL.java.exception.EmailException;
import JPL.java.util.Validator;

public class Candidate implements Comparable<Candidate>{
	private String CandidateID;
	private String FullName;
	private String BirthDay;
	private String Phone;
	private String Email;
	private int Candidate_Type;
	private static int Canidate_count=0;

	public void showInfo() {
		System.out.print("Candidate: CandidateID=" + CandidateID + ", FullName=" + FullName + ", BirthDay=" + BirthDay
				+ ", Phone=" + Phone + ", Email=" + Email + ", Candidate_Type=" + Candidate_Type + ", ");
	};
	public Candidate() {
		super();
	}
	public Candidate(String candidateID, String fullName, String birthDay, String phone, String email,
			int candidate_Type) {
		super();
		CandidateID = candidateID;
		FullName = fullName;
		BirthDay = birthDay;
		Phone = phone;
		Email = email;
		Candidate_Type = candidate_Type;
	}


	public String getCandidateID() {
		return CandidateID;
	}
	public void setCandidateID(String candidateID) {
		CandidateID = candidateID;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getBirthDay() {
		return BirthDay;
	}
	public void setBirthDay(String BirthDay) throws BirthdayException{
		if(new Validator().isValidDate(BirthDay) == true) {
			this.BirthDay = BirthDay;
		}else {
			throw new BirthdayException("Invalid Birthday! Please input again!");
		}
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) throws EmailException{
		if(new Validator().isValidEmailAddress(Email) == true) {
			this.Email = Email;
		}else {
			throw new EmailException("Invalid Email");
		}
	}
	public int getCandidate_Type() {
		return Candidate_Type;
	}
	public void setCandidate_Type(int candidate_Type) {
		Candidate_Type = candidate_Type;
	}

	public static int getCanidate_count() throws SQLException {
		setCanidate_count();
		return Canidate_count;
	}

	public static void setCanidate_count() throws SQLException {
		Canidate_count = new CandidateDaoImpl().countCandidate();
	}
	@Override
	public int compareTo(Candidate o) {
		if(this.getCandidate_Type() == o.getCandidate_Type()) {
			try {
				Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(this.getBirthDay());
				Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(o.getBirthDay());
				return date1.compareTo(date2);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return this.getCandidate_Type() > o.getCandidate_Type() ? 1 : -1;
	}
	@Override
	public String toString() {
		return "Candidate [CandidateID=" + CandidateID + ", FullName=" + FullName + ", BirthDay=" + BirthDay
				+ ", Phone=" + Phone + ", Email=" + Email + ", Candidate_Type=" + Candidate_Type + "]";
	}
	
	
}
	