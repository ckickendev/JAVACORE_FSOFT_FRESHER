package JPL.java.entities;

public class Fresher extends Candidate{
	private String Graduation_date;
	private String Graduation_rank;
	private String Education;
	
	public Fresher(String candidateID, String fullName, String birthDay, String phone, String email, int candidate_Type,
			String graduation_date, String graduation_rank, String education) {
		super(candidateID, fullName, birthDay, phone, email, candidate_Type);
		Graduation_date = graduation_date;
		Graduation_rank = graduation_rank;
		Education = education;
	}
	public String getGraduation_date() {
		return Graduation_date;
	}
	public void setGraduation_date(String graduation_date) {
		Graduation_date = graduation_date;
	}
	public String getGraduation_rank() {
		return Graduation_rank;
	}
	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}
	public String getEducation() {
		return Education;
	}
	public void setEducation(String education) {
		Education = education;
	}
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Graduation_date=" + Graduation_date + ", Graduation_rank=" + Graduation_rank + ", Education="+ Education);
	}
	@Override
	public String toString() {
		return "Fresher [Graduation_date=" + Graduation_date + ", Graduation_rank=" + Graduation_rank + ", Education="
				+ Education + "]";
	}
	
	
	
}
