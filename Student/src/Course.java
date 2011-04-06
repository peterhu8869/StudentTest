import java.util.ArrayList;


public class Course {

	private int courseID;
	private String courseDesc;
	private double cost;
	
	public Course()
	{
		setInfo();
	}
	
	public Course(int newCourseID, double newCost, String newCourseDesc)
	{
		courseID = newCourseID;
		courseDesc = newCourseDesc;
		cost = newCost;
	}
	
	public void setInfo()
	{
		System.out.println("Please enter the course description. ");
		//Takes in courseDesc.
		System.out.println("Please enter the cost of the course. ");
		//Takes in cost.
	}
	
	public int getCourseID()
	{
		return courseID;
	}
	
	public String getCourseDesc(int curCourseID)
	{
		return courseDesc; 
	}
	
	public double getCost(int curCourseID)
	{
		return cost;
	}
}
