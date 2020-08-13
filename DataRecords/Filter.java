package utility;

import college.Course;
import college.Rank;
import college.Student;
import college.Title;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Filter {
	
	List<Student> list; 
	
	public Filter() {
		list = new ArrayList<Student>(); 
	}
	
	//create a filter for the students over 25 and write it to another file location
	public void filterOver25(String location)throws FileNotFoundException{
		File        file   = new File(location);
		PrintStream output = new PrintStream(file);
		
		if(file.exists()) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).age() > 25) {
					output.println(list.get(i).toString());
				}
			}

		}
		
		output.close();		
	}
	
	//create a filter for the students under o equal to 25 and write it to another file location
	public void filterUnder25(String location)throws FileNotFoundException{
		File        file    = new File(location);
		PrintStream output  = new PrintStream(file);
		
		if(file.exists()) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).age() <= 25) {
					output.println(list.get(i).toString());
				}
			}
		}
		
		output.close();	
	}
	
	//filter students who have made the dean's list
	public void isOnDeansList(String location)throws FileNotFoundException{
		File        file   = new File(location);
		PrintStream output = new PrintStream(file);
		
		if(file.exists()) {
		for(Student student: list) {
			if(student.isOnDeansList()) {
				output.println(student.toString());
			}
		}	
		}
		output.close();		
	}
	
	//filter students who are freshman
	public void isFreshman(String location)throws FileNotFoundException{
		File        file    = new File(location);
		PrintStream output  = new PrintStream(file);
		
		sortStudent(list);
		
		if(file.exists()) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).rank() == Rank.FRESH) {
					output.println(list.get(i).toString());
				}		
			}
		}
		output.close();
	}
	
	//filter students who are sophomores
	public void isSophomore(String location)throws FileNotFoundException{
		File        file    = new File(location);
		PrintStream output  = new PrintStream(file);
		
		sortStudent(list);
		
		if(file.exists()) {
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).rank() == Rank.SOPH) {
					output.println(list.get(i).toString());
				}		
			}
		}
		output.close();
	}
	
	//create a method to sort student (using bubble sort)
	public void sortStudent(List<Student> list) {
		Student stud = null;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 1; j < list.size() - i ; j++) {
				if(list.get(j).equals(list.get(j-1)))
					list.remove(j);
					stud = list.get(j);
					if(stud.compareTo(list.get(j-1)) < 0) {
						stud = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j-1, stud);		
					}
				}
		}
	}
	
	//returns a Course object. Taking the string and returns a Course object
	public Course makeCourse(String str) throws IllegalArgumentException{
		String[]     info       = str.split("=");
		Title        prefix     = Title.valueOf(info[0]);
		List<Double> scores     = makeScores(info[1]);
		
		return new Course(prefix, scores);		
	}
	
	//returns a list of scores. This method takes the list scores as a string
	//and returns a List object
	public List<Double> makeScores(String str){
		String[]     info        = str.split(":");
		List<Double> scores      = new ArrayList<Double>();
		for(int i = 0; i < info.length; i++) {
			scores.add(Double.parseDouble(info[i]));
		}
		return scores;	
	}
	
	//returns a Student object
	public Student parse(String line) throws IllegalArgumentException{
		
		String[] info   = line.split(", ");
		String   name   = info[0];
		int      age    = Integer.parseInt(info[1]);
		Rank     rank   = Rank.valueOf(info[2]);
		
		List<Course> courses = new ArrayList<Course>();
		for(int i = 3; i < info.length; i++) {
			courses.add(makeCourse(info[i]));
			}
		return new Student(name, age, rank, courses);
	}
	
	//filter students who are on probation
	public void isOnProbation(String location)throws FileNotFoundException{
		File        file   = new File(location);
		PrintStream output = new PrintStream(file);
		
		if(file.exists()) {
		for(Student student: list) {
			if(student.isOnProbation()) {
				output.println(student.toString());
			}
		}	
		}
		output.close();		
	}
	
	//reads the content of a database file
	public void read(String location) throws FileNotFoundException{
		File    file    = new File(location);
		Scanner input   = new Scanner(file);
		
		Student student = null;
		
		
		if(file.exists()) {
		while(input.hasNextLine()) {
			 student = parse(input.nextLine());
			
			
			if(!list.contains(student)) {
				list.add(student);
		}
		}
		input.close();
	}
	}

	//sorts student data by order of age, then last name, first name
	//then GPA and writes it to the indicated file location
	public void sortAge(String location)throws FileNotFoundException{
		File file = new File(location);
		PrintStream output = new PrintStream(file);
		
		Student student1 = null;
		Student student2 = null;
		if(file.exists()) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = 1; j < list.size() - i ; j++) {
				student1 = list.get(j);
				student2 = list.get(j - 1);
				if(student1.equals(student2)) {
					list.remove(student1);
				}if(Student.compareAge(student1, student2) < 0){
					list.set(j, student2);
					list.set(j - 1, student1);
				}
			}
		}
		}
		
		//output.println(list.toString());	
		write(location);
		output.close();
	}
	
	//sorts students data in alphabetical order by last name, first name,
	//then GPA, then age and writes it to the indicated file location
	public void sortAlphabeticalOrder(String location)throws FileNotFoundException{
		File file = new File(location);
		PrintStream output = new PrintStream(file);
		
		Student stud = null;
		if(file.exists()) {
		for(int i = 0; i < list.size(); i++) {
			for(int j = 1; j < list.size() - i ; j++) {
				if(list.get(j).equals(list.get(j-1)))
					list.remove(j);
					stud = list.get(j);
					if(stud.compareTo(list.get(j-1)) < 0) {
						stud = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j-1, stud);		
					}
				}
			
		}
		}
		
		write(location);
		
		output.close();
	}
	
	//sort students data by GPA, then last name, first name, then age
	public void sortGPAOrder(String location)throws FileNotFoundException{
		File file = new File(location);
		PrintStream output = new PrintStream(file);
		
		Student stud = null;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 1; j < list.size() - i ; j++) {
				if(list.get(j).equals(list.get(j-1)))
					list.remove(j);
					if(Student.compareGPA(list.get(j), list.get(j-1)) != 0) {
						stud = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j-1, stud);
					}		
				}
		}
		
		write(location);
		output.close();
	}
	
	//write the contents of a database element to a file
	public void write (String location)throws FileNotFoundException{
		File file = new File(location);
		
		//create a file at the location indicated
		PrintStream output = new PrintStream(file);
		
		Student student = null;
		//write output to file
		for(int i = 0; i < list.size(); i++) {
			if(!list.contains(student)) {
			output.println(list.get(i));
			}
		}
		output.close();
	}
	
	//writes the contents of a database element to a file
	public void writeCS(String location)throws FileNotFoundException{
		File file = new File(location);
		PrintStream output = new PrintStream(file);
		
		
		for(int i = 0; i < list.size(); i++) {
				output.println(list.get(i).toFile());
			}
		
		output.close();
	}
}
