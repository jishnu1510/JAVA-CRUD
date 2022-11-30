package StudentCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDB {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/studentdb";
	private String uid = "root";
	private String password = "Jishnu@123";	
	
	Scanner sc= new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	
	public void addStudent() {
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,uid,password);
			
			System.out.println("Enter Student Roll No");
			int rollNo =sc1.nextInt();
			System.out.println("Enter Student name");
			String name =sc.nextLine();
			System.out.println("Enter Subject name");
			String subject =sc.nextLine();
			System.out.println("Enter Marks");
			int marks =sc1.nextInt();
			
			String query = "INSERT INTO student(rollNo,name,subject,marks) VALUES (?, ?, ?, ?)";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    
		    pstmt.setInt(1, rollNo);
		    pstmt.setString(2, name);
		    pstmt.setString(3, subject);
		    pstmt.setInt(4, marks);
		    
		    int i= pstmt.executeUpdate();
		    
			if(i==1)
			{
				System.out.println("Student Info Added Successfully");
			}
			else 
			{
				System.out.println("Info Not Added");
			}
			con.close(); 
		}
		catch(Exception e) {
			System.out.println(" Data Insertion Error");
		}
	}
	
	public void displayAll() {
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,uid,password);
			
			Statement stmt=con.createStatement();
			String query = "Select * from student";
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()==false)
			{
				System.out.println("No Data Available");
			}
			else 
			{
				do
				{	
					System.out.println("Roll No = " +rs.getInt(1));
					System.out.println("Student Name = " +rs.getString(2));
					System.out.println("Subject = " +rs.getString(3));
					System.out.println("Marks = " +rs.getInt(4));
					System.out.println("-------------------------------------");
						
				}while(rs.next());
			}
			System.out.println();
			con.close();  
		}
		catch(Exception e) {
			
		}
	}
	
	public void searchStudent() {
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,uid,password);
			
			System.out.println("Enter Student Roll No to search");
			int rollNo = sc1.nextInt();
			Statement stmt=con.createStatement();
			String query = "Select * from student where rollno ="+rollNo;
			ResultSet rs=stmt.executeQuery(query);
			if(rs.next()==false)
			{
				System.out.println("No Data Available");
			}
			else 
			{
				do
				{	
					System.out.println("Roll No = " +rs.getInt(1));
					System.out.println("Student Name = " +rs.getString(2));
					System.out.println("Subject = " +rs.getString(3));
					System.out.println("Marks = " +rs.getInt(4));
					System.out.println("-------------------------------------");
						
				}while(rs.next());
			}
			System.out.println();
			con.close();  
			
		}
		catch(Exception e) {
			
		}
	}
	
	public void updateStudent() {
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,uid,password);
			
			System.out.println("Enter Roll No to Update");
			int rollNo =sc1.nextInt();
			System.out.println("Update Subject and Marks");
			System.out.println("Enter Subject");
			String subject= sc.nextLine();	
			System.out.println("Enter Marks");
			int mark= sc1.nextInt();
			String query = "Update student set subject='"+subject+"', marks="+mark+" where rollno="+rollNo;
			PreparedStatement pstmt = con.prepareStatement(query);
			    
			int u= pstmt.executeUpdate();
			if(u==1)
			{
				System.out.println("Student info updated Successfully");
			}
			else 
			{
				System.out.println("Can't Update Date.");
			}
		}
		catch(Exception e) {
			
		}
	}

	public void deleteStudent() {
	
	try {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,uid,password);
		
		System.out.println("Enter Roll No to Delete Student Inf");
		int rollNo =sc1.nextInt();
		
		String query = "Delete from student where rollno="+rollNo;
		PreparedStatement pstmt = con.prepareStatement(query);
		int d =pstmt.executeUpdate();
		if(d==1)
		{
			System.out.println("Appointment Deleted Successfully");
		}
		else 
		{
			System.out.println("Deletion Unsuccessfully");
		}
		con.close(); 
	}
	catch(Exception e) {
		
	}
}
}
