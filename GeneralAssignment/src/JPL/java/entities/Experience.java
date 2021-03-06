package JPL.java.entities;

public class Experience extends Candidate{
	private int ExpInYear;
	private String ProSkill;
	
	public Experience(String candidateID, String fullName, String birthDay, String phone, String email,
			int candidate_Type, int expInYear, String proSkill) {
		super(candidateID, fullName, birthDay, phone, email, candidate_Type);
		ExpInYear = expInYear;
		ProSkill = proSkill;
	}
	public int getExpInYear() {
		return ExpInYear;
	}
	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}
	public String getProSkill() {
		return ProSkill;
	}
	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}
	@Override
	
	public void showInfo() {
		super.showInfo();
		System.out.println("ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill);
	}
	@Override
	public String toString() {
		return "Experience [ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill + "]";
	}
	
	
	
	
}
