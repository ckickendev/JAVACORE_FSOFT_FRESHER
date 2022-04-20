package DayOne.Assignment1_opt2_DoNVD_Java07.Question12;

public class Student {
	private String StdNo;
	private String StdName;
	private String StdPhone;
	private String StdEmail;
	private int GradePoint;
	public Student(String stdNo, String stdName, String stdPhone, String stdEmail, int gradePoint) {
		super();
		StdNo = stdNo;
		StdName = stdName;
		StdPhone = stdPhone;
		StdEmail = stdEmail;
		GradePoint = gradePoint;
	}
	public String getStdNo() {
		return StdNo;
	}
	public void setStdNo(String stdNo) {
		StdNo = stdNo;
	}
	public String getStdName() {
		return StdName;
	}
	public void setStdName(String stdName) {
		StdName = stdName;
	}
	public String getStdPhone() {
		return StdPhone;
	}
	public void setStdPhone(String stdPhone) {
		StdPhone = stdPhone;
	}
	public String getStdEmail() {
		return StdEmail;
	}
	public void setStdEmail(String stdEmail) {
		StdEmail = stdEmail;
	}
	public int getGradePoint() {
		return GradePoint;
	}
	public void setGradePoint(int gradePoint) {
		GradePoint = gradePoint;
	}
	@Override
	public String toString() {
		return "Student [StdNo=" + StdNo + ", StdName=" + StdName + ", StdPhone=" + StdPhone + ", StdEmail=" + StdEmail
				+ ", GradePoint=" + GradePoint + "]";
	}
	
}
