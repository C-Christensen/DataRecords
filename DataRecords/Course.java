package college;


import college.Course;
import college.Title;
import java.util.ArrayList;
import java.util.List;



public class Course implements Comparable<Course>{
	
	private Title         title;  //stores the course title 
	private double        gpa;    //stores the course GPA as a double
	private List<Double>  scores; //stores the student's fall scores
	
	//create a default constructor that holds class CSC142 and empty scores
	public Course() {
		title = Title.CSC;
		scores = new ArrayList<Double>();
	}
	
	//create a copy constructor
	public Course(Course other) {
		this(other.title, other.scores);
	}
	
	//create a constructor that accepts course and scores
	public Course(Title course, List<Double> scores) {
		title = course;
		this.scores = scores;
	}
	
	
	//compare the course GPA of two students
	public int compareGPA(Course other) {
		if(gpa < other.gpa) 
			return -1;
		else if(gpa > other.gpa) 
			return 1;
		else
			return 0;	
	}
	
	//compare the course name
	public int compareTo(Course other) {
		if(title.equals(other.title())){
			return 0;
		}
		return -1;	
	}
	
	//compute the course GPA 
	public double computeGPA() {
		double sum = 0.0;
		for(int i = 0; i < scores.size(); i++) {
			sum += scores.get(i);	
		}
		sum = (((sum / scores.size()) - 35.0) / 15.0);
		
		return sum;
	}
	
	//return course title
	public Title title() {
		return title;
	}
	
	
	//compare the content of two courses and return a boolean
	public boolean equals(Object other) {
		if(other instanceof Course) {
			Course object = (Course) other;
			return title.equals(object.title) &&
				   scores.equals(object.scores);
		}
		return false;
	}
	
	//compare the scores of two different courses
	public boolean equalScores(Course other) {
		return  scores.size() == other.scores.size() &&
				scores.containsAll(other.scores);
	}
	
	//return the GPA of the course
	public double gpa() {
		return computeGPA();
	}
	
	//sets the title of the course
	public void setTitle(Title title) {
		this.title = title;
	}
	
	//return the course information separated by comma 
	public String toFile() {
		String result = title.name() + "=";
		for(int i = 0; i < scores.size() - 1; i++) {
			result += Math.round(scores.get(i)) + ":";
		}
		
		result += Math.round(scores.get(scores.size() - 1));
		return result;
	}

	@Override
	public String toString() {
		return String.format("%s \t%.2f \n", title, computeGPA());
		
	}
	
	
}


