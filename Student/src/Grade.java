import java.util.ArrayList;


public class Grade {

	private int grade;
	private int studentID;
	private int courseID;
	
	public Grade(ArrayList<Student> studentList, ArrayList<Course> courseList)
	{
		setInfo();
		studentList.get(0).getStudentID();
		courseList.get(0).getCourseID();
	}
	
	public Grade(int newStudentID, int newCourseID, int newGrade)
	{
		studentID = newStudentID;
		courseID = newCourseID;
		grade = newGrade;
	}
	
	public void setInfo()
	{
		System.out.println("Please enter the grade. ");
		//Takes in grade
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public void setGradeDB()
	{
		
	}
}