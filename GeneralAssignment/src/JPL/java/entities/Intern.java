package JPL.java.entities;

public class Intern extends Candidate{
	private String Majors;
	private String Semester;
	private String University_name;
	
	public Intern(String candidateID, String fullName, String birthDay, String phone, String email, int candidate_Type,
			String majors, String semester, String university_name) {
		super(candidateID, fullName, birthDay, phone, email, candidate_Type);
		Majors = majors;
		Semester = semester;
		University_name = university_name;
	}
	
	public String getMajors() {
		return Majors;
	}
	public void setMajors(String majors) {
		Majors = majors;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	public String getUniversity_name() {
		return University_name;
	}
	public void setUniversity_name(String university_name) {
		University_name = university_name;
	}
	

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Majors=" + Majors + ", Semester=" + Semester + ", University_name=" + University_name);
	}

	@Override
	public String toString() {
		return "Intern [Majors=" + Majors + ", Semester=" + Semester + ", University_name=" + University_name + "]";
	}
	
	
}
