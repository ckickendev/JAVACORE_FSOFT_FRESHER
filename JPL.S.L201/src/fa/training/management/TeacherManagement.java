package fa.training.management;

import fa.training.entities.MathTeacher;

public class TeacherManagement {
	public static void main(String[] args) {

        MathTeacher teacher = new MathTeacher("Teacher", "FU", "Math");
        System.out.println(teacher);

//        System.out.println("Colleage name: " + teacher.getCollegename());
//        System.out.println("Designation: " + teacher.getDesignation());
//        System.out.println("Main subject: " + teacher.getMainSubject());
        teacher.teach();
        System.out.println(" sum(20, 80) = " + teacher.sum(20, 80));

    }
}
