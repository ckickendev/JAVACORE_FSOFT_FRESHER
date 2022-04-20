package fa.training.models;

import java.io.Serializable;

import fa.training.utils.InvalidIdException;
import fa.training.utils.PhoneFormatException;
import fa.training.utils.Validator;

/**
 * 
 *
 */
public class Student implements Serializable {

  private static final long serialVersionUID = 1L;
  private String id;
  private String name;
  private String phone;
  private String gender;
  private double gpa;

  public Student(String name, String phone, String gender, String id,
      double gpa) {
    super();
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.gender = gender;
    this.gpa = gpa;
  }

  public Student() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) throws InvalidIdException {
    if (Validator.isStudentId(id)) {
      this.id = id;
    } else {
      throw new InvalidIdException("Id is invalid!");
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) throws PhoneFormatException {
    if (Validator.isPhone(phone)) {
      this.phone = phone;
    } else {
      throw new PhoneFormatException("Email is invalid!");
    }
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public double getGpa() {
    return gpa;
  }

  public void setGpa(double gpa) {
    this.gpa = gpa;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", phone=" + phone
        + ", gender=" + gender + ", gpa=" + gpa + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

}
