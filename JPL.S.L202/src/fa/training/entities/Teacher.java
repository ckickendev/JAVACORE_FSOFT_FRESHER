package fa.training.entities;

public abstract class Teacher {
    private String designation;
    private String collegename;

    public Teacher() {
    }

    public Teacher(String designation, String collegename) {
        super();
        this.designation = designation;
        this.collegename = collegename;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public abstract void teach();

    public void teach(int duration) {
        System.out.println("Teaching in " + duration + " minutes");
    }

}
