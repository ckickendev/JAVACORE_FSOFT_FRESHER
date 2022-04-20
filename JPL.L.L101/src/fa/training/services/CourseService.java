package fa.training.services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import fa.training.models.Course;
import fa.training.models.CourseTitleCompare;
import fa.training.models.Student;
import fa.training.utils.Constant;
import fa.training.utils.InvalidIdException;
import fa.training.utils.Validator;

/**
 * 
 *
 */
public class CourseService {
  public List<Course> createCourse(Scanner scanner) {
    String loop, id, title, credit, enrollment;
    double doCredit;
    int intEnrollment;
    Course course;
    Set<Student> students = new HashSet<Student>();
    List<Course> courses = new ArrayList<Course>();
    StudentService studentService = new StudentService();

    do {
      course = new Course();
      // Set course id
      do {
        System.out.println("Enter course id:");
        id = scanner.nextLine();
        try {
          course.setId(id);
        } catch (InvalidIdException e) {
          continue;
        }
        break;
      } while (true);

      // Set course title
      System.out.println("Enter course title:");
      title = scanner.nextLine();
      course.setTitle(title);

      // Set course credit
      do {
        System.out.println("Enter course credit:");
        credit = scanner.nextLine();
        try {
          doCredit = Validator.isCredit(credit);
          course.setCredit(doCredit);
        } catch (NumberFormatException e) {
          continue;
        }
        break;
      } while (true);

      // Set course enrollment
      do {
        System.out.println("Enter course enrollment:");
        enrollment = scanner.nextLine();
        try {
          intEnrollment = Validator.isEnrollment(enrollment);
          course.setEnrollment(intEnrollment);
        } catch (NumberFormatException e) {
          continue;
        }
        break;
      } while (true);

      // Set student to the course
      System.out.println("----Enter Student in the Course----");
      students = studentService.createStudent(scanner, intEnrollment);
      course.setStudents(students);

      // Add course to list
      courses.add(course);

      // Do you want to continue?
      System.out.println("Do you want continue to input course (Y/N)?: ");
      loop = scanner.nextLine();
    } while (loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
    return courses;
  }

  /**
   * Save list of courses to file
   * 
   * @param courses
   * @return
   * @throws Exception
   */
  public String save(List<Course> courses) throws Exception {
    ObjectOutputStream objectOutputStream = null;
    try {
      objectOutputStream = new ObjectOutputStream(new FileOutputStream(
          Constant.FILE_PATH));
      objectOutputStream.writeObject(courses);
    } catch (Exception exception) {
      throw new Exception();
    } finally {
      if (objectOutputStream != null) {
        objectOutputStream.close();
      }
    }
    return Constant.SUCCESS;
  }

  /**
   * Get all the course in file
   * 
   * @return
   * @throws IOException
   */
  @SuppressWarnings("unchecked")
  public List<Course> getAll() throws IOException {
    ObjectInputStream objectInputStream = null;
    List<Course> courses;
    try {
      objectInputStream = new ObjectInputStream(new FileInputStream(
          Constant.FILE_PATH));
      courses = (List<Course>) objectInputStream.readObject();
    } catch (Exception exception) {
      throw new IOException();
    } finally {
      if (objectInputStream != null) {
        objectInputStream.close();
      }
    }
    return courses;
  }

  /**
   * Sort and display the course by id
   * 
   * @param listBook
   */
  public void sortAndDisplay(List<Course> courses) {

    Collections.sort(courses, new CourseTitleCompare());

    System.out.println("---------------COURSE LIST-------------------");

    for (Course course : courses) {
      System.out.format("%s%20s%12.3f%5d%100s%n", course.getId(),
          course.getTitle(), course.getCredit(), course.getEnrollment(),
          course.getStudents());
    }
  }


  
  public List<Course> getByStudent(String studentId) throws IOException {
    List<Course> courses = getAll();
    List<Course> coursesByStudent = new ArrayList<Course>();

    if (courses != null) {
      for (Course course : courses) {
        for (Student studentCourse : course.getStudents()) {
          if (studentId.equalsIgnoreCase(studentCourse.getId())) {
            coursesByStudent.add(course);
          }
        }
      }
    }
    return coursesByStudent;
  }

  public String remove(String id) throws Exception {
    boolean removed = false;

    List<Course> courses = getAll();
    if (courses == null) {
      throw new IOException();
    }
    Iterator<Course> iterator = courses.iterator();
    while (iterator.hasNext()) {
      Course course = iterator.next();
      if (id.equalsIgnoreCase(course.getId())) {
        iterator.remove();
        removed = true;
        break;
      }
    }

    if (removed) {
      try {
        // update list
        save(courses);
      } catch (Exception e) {
        throw new Exception();
      }
      
      return Constant.SUCCESS;
    }
    return Constant.FAIL;
  }

}
