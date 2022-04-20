package fa.training.entities;

public class EnglishTeacher extends Teacher implements Actionable{
	private String mainSubject;

    public EnglishTeacher() {
    }

    public EnglishTeacher(String designation, String collegename, String mainSubject) {
        super(designation, collegename);
        this.mainSubject = mainSubject;
    }

    public String getMainSubject() {
        return mainSubject;
    }

    public void setMainSubject(String mainSubject) {
        this.mainSubject = mainSubject;
    }

    @Override
    public void teach() {
        System.out.println("Teaching English subject");
    }

    @Override
    public void toSchool() {
        System.out.println("English teacher go to school by motorbike");
    }

    public String translate(String en, String vi) {
        return en + " in Vietnamese " + vi;
    }

    @Override
    public String toString() {
        return "EnglishTeacher [mainSubject=" + mainSubject + ", getDesignation()=" + getDesignation()
                + ", getCollegename()=" + getCollegename() + "]";
    }
}
