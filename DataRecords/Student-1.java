package college;

import college.Course;
import college.Student;
import college.Rank;

import java.util.List;



public class Student implements Comparable<Student> {
	
	private String       name;      //stores student's name
	private int          age;       //stores student's age
	private double       gpa;       //stores student's overall GPA
	private Rank         rank;		//stores student's rank
	private List<Course> courses;	//stores student's fall courses
	
	
	//create a constructor that accepts a class type of its static inner class
	public Student(String name, int age, Rank rank, List<Course> courses) {
		this.name    = name;
		this.age     = age;
		this.rank    = rank;
		this.courses = courses;
		this.gpa     = gpa();
	}
	
	//create a copy constructor
	public Student (Student other) {
		this(other.name, other.age, other.rank, other.courses);
	}
	
	//retrieves the information in the age data field
	public int age() {
		return age;
	}
	
	//compare age of each student
	public static int compareAge(Student stud1, Student stud2) {
		if(stud1.age() != stud2.age()) {
			return stud1.age() - stud2.age();
		}else if(!stud1.lastName().equals(stud2.lastName())){
			return stud1.lastName().compareTo(stud2.lastName());
		}else if(!stud1.firstName().equals(stud2.firstName())) {
			return stud1.firstName().compareTo(stud2.firstName());
		}
		return compareGPA(stud1, stud2);
	}	
	
	//compares the overall GPA of two students
	public int compareGPA(Student other) {	
		if(Math.abs(computeGPA() - other.computeGPA()) < 0.0001) 
			return -1;	
		return 0;	
	}
	
	public static int compareGPA(Student stud1, Student stud2) {
		if(stud1.gpa() < stud2.gpa() ) {
			return stud1.compareGPA(stud2);
		}else if (stud1.lastName().compareTo(stud2.lastName()) != 0){
			return stud1.lastName().compareTo(stud2.lastName());
		}else if (stud1.firstName().compareTo(stud2.firstName()) != 0) {
			return stud1.firstName().compareTo(stud2.firstName());
		}
		return stud1.age - stud2.age;
	}
	
	//
	
	//compare the current student to another student
	@Override
	public int compareTo(Student other) {
		if(lastName().compareTo(other.lastName()) != 0){
			return lastName().compareTo(other.lastName());
		}else if (firstName().compareTo(other.firstName()) != 0) {
			return firstName().compareTo(other.firstName());
		}else if (compareGPA(other) != 0) {
			return compareGPA(other);
		}	
		return age - other.age;
	}
	
	//computes the overall GPA of a student (including all courses)
	public double computeGPA() {
		double sum = 0.0;
		for(int i = 0; i < courses.size(); i++) {
			sum += courses.get(i).gpa();
		}
		return sum / courses.size();	
	}

	//return the list of courses student is taking
	public List<Course> courseList(){
		return courses;	
	}
	
	//returns a formatted representation of the courses for display (each on a new line)
	public String courses() {
		String result = "";
		for(int i = 0; i < courses.size(); i++) {
			result += courses.get(i);
		}
		return result;	
	}
	
	//return a String if student is on Dean's lit
	public String deansList() {
		if(isOnDeansList()) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	//compare courses taken by two students
	public boolean equalCourses(Student other) {
		return  courses.size() == other.courses.size() &&
				courses.containsAll(other.courses);
		
	}
	
	//compare two student objects
	public boolean equals(Object object) {
		//if the object passed equals to the object Student
		if(object instanceof Student) {
			Student other = (Student) object;
			//return students names, age, rank and courses 
			return  name.equals(other.name) &&
					age == other.age        &&
					rank.equals(other.rank) &&
					gpa == other.gpa		&&
					courses.equals(other.courses);
		}
		return false;
	}
	
	//return first name of a student
	public String firstName() {
		String[] info      = name.split(" ");   //split the name of the student
		return  info[0];                       //return first name of the student
	}
	
	//return the overall GPA for all courses of a student
	public double gpa() {
		//if GPA is less than 0 or greater than 4, return a illegalArgumentException
		if(gpa < 0.0 || gpa > 4.0) {
			throw new IllegalArgumentException("Gpa needs to be between 0.0 and 4.0");
		}
		return computeGPA();
	}
	
	//return a boolean if student is on dean's list or not
	public boolean isOnDeansList() {
		//if GPA is greater or equal to 3.7, return true
		if(computeGPA() >= 3.70) 
			return true;
		return false;
	}
		
	//return a boolean if student is on probation or not
	public boolean isOnProbation() {
		//if GPA is less than 2.0, return true
		if(computeGPA() < 2.0) 
			return true;
		return false;
	}
	
	//return last name of a student
	public String lastName() {
		String[] fullName  = name.split(" ");     //split the name of the student
		return fullName[1];                       //return first name of the student
	}
		
	//retrieve the information in the name data field
	public String name() {
		return name;
	}
	
	//return a string if student is on probation
	public String onProbation() {
		if(isOnProbation()) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	//retrieve information in the rank data field
	public Rank rank() {
		return rank;
	}
	
	public void setAge(int age) {
		if(age < 0) {
			throw new IllegalArgumentException("Cannot be less than 0");
		}
		this.age = age;
		
	}
	
	//returns the student record in comma separated format
	public String toFile() {
		String result = name + ", " + age + ", " + rank.name() + ", ";
		for (int i = 0; i < courses.size() - 1; i++) {
			result += courses.get(i).toFile() + ", ";
		}
		result += courses.get(courses.size() - 1).toFile();
		return result;
	}
	
	//return the student record in "pretty print" format
	public String toString() {		
		return        "Name: \t"       + " \t"   + name            + "\n" 
					+ "Age:  \t"       + " \t"   + age             + "\n"
					+ "Rank: \t"       + " \t"   + rank            + "\n"
					+ "------------------------"		          + "\n"
					+ this.courses()		                         
					+ "------------------------"		          + "\n"
					+ String.format("Cum. GPA:\t%.2f \n", computeGPA())
					+ "Deans List: "   + " \t"   + deansList() + "\n"
					+ "On probation: " + " \t"   + onProbation() + "\n";
		
	}

	
}
