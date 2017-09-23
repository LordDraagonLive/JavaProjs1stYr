/*Created by Buddhi Adhikari 2015138 w1628080*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class MainInterface {
	public static int studCount = 0 ;
	public static int overalTotal;
	public static List<Student> myArrList = new ArrayList<Student>(); //Declaring ArrayList inherits from List
	public static String belowAvgOut;
	static int studTotal= 0 ;
	static int studAvg= 0 ;
	static String maxStudName;
	static int proj01;
	static int ict01;
	static int attendanceComp01;
	static int codeAssign;
	static int ict02 ;
	static int attendanceComp02;
	static int proj02;
	static int ict03 ;
	static int attendanceComp03;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean exitLoop = false;
		
		// to get the student details as input - Question Number 01
		do{
			System.out.print("Please enter the Student registration number\t:");
			String regNo = sc.next();
			System.out.print("Please enter the first name of the student\t:");
			String fname = sc.next();
			System.out.print("Please enter the last name of the student\t:");
			String lname = sc.next();
			System.out.print("Please enter the email of the student\t:");
			String email = sc.next();
			
			
			//getting user's value while validating the inputs
			proj01 = validateUserInput("Please enter Project 01 Marks\t:", sc); 
			ict01 = validateUserInput("Please enter In-class Test 01  Marks\t:", sc);
			attendanceComp01 = validateUserInput("Please enter the number of classes attended out of the 100 classes\t:", sc);
			codeAssign = validateUserInput("Please enter the Coding Assignment Marks\t:", sc); 
			ict02 = validateUserInput("Please enter In-class Test 02 Marks\t:", sc);
			attendanceComp02 = validateUserInput("Please enter the number of classes attended out of the 100 classes\t:", sc);
			ict03 = validateUserInput("Please enter In-class Test 03 Marks\t:",sc);
			proj02 = validateUserInput("Please enter Project 02 Marks\t:", sc); 
			attendanceComp03 = validateUserInput("Please enter the number of classes attended out of the 100 classes\t:", sc);
			
			//Main Component 01 - Project 01 with In-class test
			int mainComp01 = (int) ((proj01*0.20)+(ict01*0.70)+(attendanceComp01*0.10));
			//Average of Main Component 01 
			
			@SuppressWarnings("unused")
			int avgMainComp01=mainComp01/3;
			//Main Component 02 - Coding Assignment with In-class test
			int mainComp02 = (int) ((codeAssign*0.50)+(ict02*0.40)+(attendanceComp02*0.10));
			//Average of Main Component 02
			@SuppressWarnings("unused")
			int avgMainComp02=mainComp02/3;
			//Main Component 03 - Project 02 with In-class test 
			int mainComp03 = (int) ((proj02*0.30)+(ict03*0.60)+(attendanceComp03*0.10));
			//Average of Main Component 03
			@SuppressWarnings("unused")
			int avgMainComp03=mainComp03/3;
			
			//calculating average for each student
			studTotal = (int)Math.round(mainComp01 * .30  + mainComp02 * .35 + mainComp03 * .35);//Overall Total of main components
			studAvg = studTotal/3; //Student average
		
			//counting the number of students
			studCount++; 
			
			//creating an object from student class
			Student studDetails = new Student(fname, lname,regNo,email,mainComp01, mainComp02, mainComp03,studAvg );
			myArrList.add(studDetails);
			//overall Total which will consider all the students
			overalTotal=(int) (overalTotal+((mainComp01)*.30)+((mainComp02)*.35)+((mainComp03)*.35));
			
			
			// Prompting the user to quit the program or continue the program 
			System.out.println("Do you want to continue (Type N to discontinue / any other to continue)");
			String userValue = sc.next();
			if(userValue.equals("N")||userValue.equals("n")){
				exitLoop = true;
			}
			
		}while (exitLoop != true); // Terminates the program when stop = true
		
		//finding the number of students who scored below 40 for each component
		int numOfMarkComp01 = 0;
		int numOfMarkComp02 = 0;
		int numOfMarkComp03 = 0;
		
		for(Student obj : myArrList){
			
			if (obj.getMainComp01() < 40){
				numOfMarkComp01++;
			}
			
			if (obj.getMainComp02() < 40){
				numOfMarkComp02++;
			}
			
			if (obj.getMainComp03() < 40){
				numOfMarkComp03++;
			}
			
		}
			
		System.out.println("Number of students below 40 in Project 01 with In-class test is : "+numOfMarkComp01);
		System.out.println("Number of students below 40 in Coding Assignment with In-class test is : "+numOfMarkComp02);
		System.out.println("Number of students below 40 in Project 02 with In-class test  is : "+numOfMarkComp03+"\n");

		
		
		System.out.println("Class Average: "+ calcClassAvg()); //class average by all students for all the components
		System.out.println(" "); //to make the program more user-friendly
		
		
		
		//sorting the students based on their overall marks in the descending order
		System.out.println("All Student Results: \n***********************************************************************");
		Collections.sort(myArrList);
		for (int i = (myArrList.size() - 1); i >= 0; i--){
			System.out.println(myArrList.get(i));
		}
		System.out.println("*******************************************************************************************");
		System.out.println("\n");
		belowAvg();
		System.out.println("\n");
		MaxTotalMarks();
		System.out.println("\n");
		System.out.println("*******************************************************************************************");
		FindRetakes();
		System.out.println("*******************************************************************************************");
		FindResits();
		System.out.println("*******************************************************************************************");
		FindPasses();
		System.out.println("*******************************************************************************************");
		FindCredits();
		System.out.println("*******************************************************************************************");
		FindDistinction();
		System.out.println("*******************************************************************************************");
		FindHD();
		
		
	}
	//Calculating class average
	private static double calcClassAvg() {
		double avg = 0.0;
		// Divides the overall total for the main components by the number of students
		avg = overalTotal/studCount;		
		return avg;
		
	}
	
	
	
				
		/*Finding students whose total module marks fall below 
			the class average and display their details with suitable headings.*/
		public static void belowAvg(){	
			System.out.println("List of students with module marks below the class average");
			System.out.println("**************************************************************************************");
			System.out.println("Reg_No\t " + "Last Name\t " + "First Name\t " + "Module Marks\t " + "Class Average\t ");
			System.out.println("**************************************************************************************");

			for(Student studObj : myArrList){
				if(studObj.getOveralMarks()< calcClassAvg()){
					belowAvgOut = " "+studObj.getRegNo()+"\t\t"+ studObj.getfName() +"\t"
							+ "\t"+studObj.getlName()+"\t\t"+studObj.getOveralMarks()+"\t\t"+calcClassAvg();
					System.out.println(belowAvgOut);
				}
			}
		
		}
	
		// this method would print the maximum mark obtained
		private static void MaxTotalMarks(){
			int max=0;
			for(Student obj : myArrList){
				if(obj.getOveralMarks()> max){
					max = obj.getOveralMarks();
					maxStudName = obj.getfName();
				}
				
			}
			System.out.println("");
			System.out.println("The highest total score is by " + maxStudName + " who gain a mark of " + max+"\n");
		}
		
		private static void FindRetakes(){
			
			System.out.println("Students who needs to retake the module:\n");	
			//Displays the students who should retake the module
			for (int i = (myArrList.size() - 1); i >= 0; i--){
							
				if (myArrList.get(i).getGrade() == Grade.RETAKE){			
					System.out.println(myArrList.get(i));
				}			
			}
			
			
		}
		private static void FindResits(){
			
			System.out.println("Students who needs to resit the module:\n");	
			//Displays the students who should resit the module
			for (int i = (myArrList.size() - 1); i >= 0; i--){
							
				if (myArrList.get(i).getGrade() == Grade.RESIT){			
					System.out.println(myArrList.get(i));
				}			
			}
			
			
		}
		
		private static void FindPasses(){
			
			System.out.println("Students who passed the module:\n");	
			//Displays the students who passed the module
			for (int i = (myArrList.size() - 1); i >= 0; i--){
							
				if (myArrList.get(i).getGrade() == Grade.PASS){			
					System.out.println(myArrList.get(i));
				}			
			}
			
			
		}
		private static void FindCredits(){
			
			System.out.println("Students got credit to the module:\n");	
			//Displays the students who got credit to the module
			for (int i = (myArrList.size() - 1); i >= 0; i--){
							
				if (myArrList.get(i).getGrade() == Grade.CREDIT){			
					System.out.println(myArrList.get(i));
				}			
			}
			
			
		}
		private static void FindDistinction(){
			
			System.out.println("Students who got distinction to the module:\n");	
			//Displays the students who got distinction to the module
			for (int i = (myArrList.size() - 1); i >= 0; i--){
							
				if (myArrList.get(i).getGrade() == Grade.DISTINCTION){			
					System.out.println(myArrList.get(i));
				}			
			}
			
			
		}
		private static void FindHD(){
			
			System.out.println("Students who got higher distinction to the module:\n");	
			//Displays the students who got higher distinction to the module
			for (int i = (myArrList.size() - 1); i >= 0; i--){
							
				if (myArrList.get(i).getGrade() == Grade.HD){			
					System.out.println(myArrList.get(i));
				}			
			}
			
			
		}
		
	private static int validateUserInput(String validate, Scanner sc ) {
		int marks=0;
		
		do{
			System.out.print(validate);
			while(!sc.hasNextInt()){
				
				System.err.println("Invalid input please enter a marks within the range of 0 to 100");
				sc.next();
				
				
			}
			marks = sc.nextInt();
			if (!(marks >= 0 && marks <= 100)){
				System.err.println("Invalid marks and input a marks within the range of 0 to 100");
			}
		}while (!(marks >= 0 && marks <= 100));
		
		return marks;
	}
	}


