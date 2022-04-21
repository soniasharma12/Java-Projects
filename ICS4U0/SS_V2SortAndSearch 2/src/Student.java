/*
 *  *********** Assignment Information **********
 * Name: Sonia Sharma
 * Course: ICS4U0
 * Assignment: V2 Sort and Search Algorithms
 * Due Date: March 28th, 2022
 * Description: This is the Student Object class which stores added Student's information
 */
public class Student 
{
  String name;// stores student's name
  int studentId, grade;// stores student's ID and grade
  
  public Student(String name, int studentId, int grade) 
  {
    this.name = name;
    this.studentId = studentId;
    this.grade = grade;
  }
  
  // get student's name
  public String getName() 
  { 
	  return name;
  }  

  // set student's name
  public void setName(String name)
  { 
	  this.name = name;
  }

  // get student's Id
  public int getStudentId() 
  { 
	  return studentId; 
  }

  // set student's Id
  public void setStudentId(int studentId) 
  { 
	  this.studentId = studentId; 
  }

  // get student's grade
  public int getGrade() 
  { 
	  return grade; 
  }

  // set student's grade
  public void setGrade(int grade) 
  { 
	  this.grade = grade; 
  }
}// Student object class
