package StudentCRUD;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentDB stu = new StudentDB();
		Scanner select=new Scanner(System.in);
		while(true)
		{
		System.out.println("\n");
		System.out.println("Welcome to our System");
		System.out.println(" 1.Insert Student Info \n 2.Search Student Info \n 3.Update Update Student Info\n 4.Delete Student Info \n 5.Exit");
		int ch=select.nextInt();
		switch(ch)
		{
		case 1: stu.addStudent();
		break;
		case 2: System.out.println("1.Display All Student \n 2.Search Student");
				int ch1 = select.nextInt();
				if(ch1==1) {
					stu.displayAll();
				}
					else if(ch1==2) {
						stu.searchStudent();
					}
					else {
						System.exit(0);
					}
		break;
		case 3: stu.updateStudent();
		break;
		case 4: stu.deleteStudent();
		break;
		case 5: System.out.print("Thank you");
		System.exit(0);
		default: System.out.println("Invalid number enter between 1 to 4");
		}
	}

	}

}
