
public class Student {

	private String lname;
	private String fname;
	private int studentID;
	private int studentCount;
	
	public Student()
	{
		getInfo();
		studentID = studentCount + 1;
	}
	
	public Student(int newStudentID, String newLName, String newFName)
	{
		studentID = newStudentID;
		lname = newLName;
		fname = newFName;
		
	}
	
	public void getInfo()
	{
		System.out.println("Please enter the first name of the student. ");
		//Takes in fname.
		System.out.println("Please enter the last name of the student. ");
		//Takes in lname.
	}
	
	public int getStudentID()
	{
		return studentID;
	}
	
	public String getFname(int curStudentID)
	{
		return fname;
	}
	
	public String getLname(int curStudentID)
	{
		return lname;
	}
}
