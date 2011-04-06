import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.sql.*; 


@SuppressWarnings("serial")
public class UserFrame extends JFrame{

	private JPanel panel = new JPanel();
	private JLabel student = new JLabel("Student ID: ");
	private JLabel course = new JLabel("Course ID: ");
	private JLabel grade = new JLabel("Grade: ");
	private JButton viewButton= new JButton("View Schedule");
	private JButton addStudentButton = new JButton("Add Student");
	private JButton addCourseButton = new JButton("Add Course");
	private JButton addGradeButton = new JButton("Add Grade");
	private JButton removeStudentButton = new JButton("Remove Student");
	private JButton removeCourseButton = new JButton("Remove Course");
	private JButton removeGradeButton = new JButton("Remove Grade");
	private JButton exitButton= new JButton("Exit");
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Course> courseList = new ArrayList<Course>();
	private ArrayList<Grade> gradeList = new ArrayList<Grade>();
	private Connection connection;
	
	public UserFrame() throws SQLException
	{
		connectDB();
		resetDB();
		setDB();
		createPanel();
		createListeners();
		setTitle("Student Schedule");
		setSize(180,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void connectDB(){
		
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MySQL","root","WIT2012"); 
			System.out.println("Connection succeed!"); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
		
	} 
	
	public void addDB() throws SQLException
	{
		connection.createStatement().execute("INSERT INTO `student_schema`.`student` (`STUDENT_ID`, `LAST_NAME`, `FIRST_NAME`) VALUES (1, 'Smith', 'Bob');");

	}
	
	public void createPanel()
	{
		panel.add(viewButton);
		panel.add(addStudentButton);
		panel.add(addCourseButton);
		panel.add(addGradeButton);
		panel.add(removeStudentButton);
		panel.add(removeCourseButton);
		panel.add(removeGradeButton);
		panel.add(exitButton);
		add(panel);
	}
	
	public void createListeners()
	{
		ActionListener addStudentListener = new AddStudent();
		ActionListener addCourseListener = new AddCourse();
		ActionListener addGradeListener = new AddGrade();
		ActionListener removeStudentListener = new RemoveStudent();
		ActionListener removeCourseListener = new RemoveCourse();
		ActionListener removeGradeListener = new RemoveGrade();
		ActionListener view = new View();
		ActionListener exit = new Exit();
		addStudentButton.addActionListener(addStudentListener);
		addCourseButton.addActionListener(addCourseListener);
		addGradeButton.addActionListener(addGradeListener);
		removeStudentButton.addActionListener(removeStudentListener);
		removeCourseButton.addActionListener(removeCourseListener);
		removeGradeButton.addActionListener(removeGradeListener);
		viewButton.addActionListener(view);
		exitButton.addActionListener(exit);
	}

	public void setDB() throws SQLException
	{
		/*studentList.add(0, new Student(1, "Smith', "Bob"));
		studentList.add(1, new Student(2, "Doe", 'Jane'));
		studentList.add(2, new Student(3, "Kirk", 'Paul'));
		studentList.add(3, new Student(4, "Merrel", 'Jim'));
		sudentList.add(4, new Student(5, 'Smith', 'Jane'));*/

		//Adds items into the student table
		connection.createStatement().execute("INSERT INTO `student_schema`.`student` (`STUDENT_ID`, `LAST_NAME`, `FIRST_NAME`) VALUES (1, 'Smith', 'Bob');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`student` (`STUDENT_ID`, `LAST_NAME`, `FIRST_NAME`) VALUES (2, 'Doe', 'Jane');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`student` (`STUDENT_ID`, `LAST_NAME`, `FIRST_NAME`) VALUES (3, 'Kirk', 'Paul');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`student` (`STUDENT_ID`, `LAST_NAME`, `FIRST_NAME`) VALUES (4, 'Merrel', 'Jim');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`student` (`STUDENT_ID`, `LAST_NAME`, `FIRST_NAME`) VALUES (5, 'Smith', 'Jane');");

		/*courseList.add(0, new Course(1, 100, "Description 1"));
		courseList.add(1, new Course(2, 200, "Description 2"));
		courseList.add(2, new Course(3, 300, "Description 3"));
		courseList.add(3, new Course(4, 400, "Description 4"));
		courseList.add(4, new Course(5, 500, "Description 5"));*/
		
		//Adds items into the course table
		connection.createStatement().execute("INSERT INTO `student_schema`.`course` (`COURSE_ID`, `COST`, `COURSE_DESCRIPTION`) VALUES (1, 100, 'Description 1'); ");
		connection.createStatement().execute("INSERT INTO `student_schema`.`course` (`COURSE_ID`, `COST`, `COURSE_DESCRIPTION`) VALUES (2, 200, 'Description 2');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`course` (`COURSE_ID`, `COST`, `COURSE_DESCRIPTION`) VALUES (3, 300, 'Description 3'); ");
		connection.createStatement().execute("INSERT INTO `student_schema`.`course` (`COURSE_ID`, `COST`, `COURSE_DESCRIPTION`) VALUES (4, 400, 'Description 4'); ");
		connection.createStatement().execute("INSERT INTO `student_schema`.`course` (`COURSE_ID`, `COST`, `COURSE_DESCRIPTION`) VALUES (5, 500, 'Description 5');");
		
		//Adds items into the grade table
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (1, 1, 'A');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (1, 2, 'B');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (1, 3, 'C');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (1, 4, 'D');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (1, 5, 'E');");
		
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (2, 1, 'A');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (2, 2, 'B');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (2, 3, 'C');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (2, 4, 'D');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (2, 5, 'E');");

		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (3, 1, 'A');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (3, 2, 'B');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (3, 3, 'C');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (3, 4, 'D');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (3, 5, 'E');");

		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (4, 1, 'A');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (4, 2, 'B');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (4, 3, 'C');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (4, 4, 'D');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (4, 5, 'E');");

		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (5, 1, 'A');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (5, 2, 'B');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (5, 3, 'C');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (5, 4, 'D');");
		connection.createStatement().execute("INSERT INTO `student_schema`.`grade` (`Student_ID`, `Course_ID`, `grade`) VALUES (5, 5, 'E');");

	}
	
	public void resetDB() throws SQLException
	{
		connection.createStatement().execute("DELETE FROM `student_schema`.`grade`;");
		connection.createStatement().execute("DELETE FROM `student_schema`.`course`;");
		connection.createStatement().execute("DELETE FROM `student_schema`.`student`;");
	}
	
	class AddStudent implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			studentList.add(0, new Student());
		}     
	}
	
	class AddCourse implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			courseList.add(0, new Course());
		}     
	}
	
	class AddGrade implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//gradeList.add(0, new Grade());
		}     
	}
	
	class RemoveStudent implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//studentList.remove(0);
			System.out.println("Student Removed");
		}     
	}
	
	class RemoveCourse implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//courseList.remove(0);
			System.out.println("Course Removed");
		}     
	}
	
	class RemoveGrade implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//gradeList.remove(0);
			System.out.println("Grade Removed");
		}     
	}
	
	class View implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int count = 0;
			for (int i = 0; i < studentList.size(); i++)
				{
				for (int j = 0; j < courseList.size(); j++)
					{
						System.out.println("Student ID: " + studentList.get(i).getStudentID() + " Course ID: " + courseList.get(j).getCourseID() + " Grade: " + gradeList.get(count).getGrade());
						count ++;
					}
				}
	
			System.out.println("View Pressed");
		}     
	}
	
	class Exit implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}     
	}
	
}
