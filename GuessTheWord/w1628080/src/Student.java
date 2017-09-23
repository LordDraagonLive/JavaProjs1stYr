
public class Student implements Comparable<Student> {
	private String fName;
	private String lName;
	private String regNo;
	private int mainComp01;
	private int mainComp02;
	private int mainComp03;
	private int overalMarks;
	private String email;
	private Grade grade;
	private int avg;
	private double qualiSet;
	
	public Student() {
		 
	
	}
	public Student(String fName, String lName, String regNo,String email,
					int mainComp01, int mainComp02, int mainComp03,int avg) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.regNo = regNo;
		this.email= email;
		this.mainComp01 = validateUserInput(mainComp01);
		this.mainComp02 = validateUserInput(mainComp02);
		this.mainComp03 = validateUserInput(mainComp03);
		this.avg= avg;
		calcOveralMarks();
		calcGrade();
		
		
	}
	// Below method calculates the grade based on the qualifying set and the overalMarks
	private void calcGrade() {
		
		qualiSet=((mainComp01*0.30) + (mainComp02*0.35)); // qualifying set initialisation 
		
		if(overalMarks>=80){
			grade = Grade.HD;
		}else if (overalMarks >=70){
			grade = Grade.DISTINCTION;
		}else if(overalMarks >=60){
			grade = Grade.CREDIT;
		}else if(overalMarks >=50 && qualiSet>=40 && mainComp03>=40 ){
			grade = Grade.PASS;	
		}else if(overalMarks <50){
			grade = Grade.RETAKE;
		}
		if (overalMarks >= 50 &&(qualiSet <= 39 || mainComp03 <= 39)){
			grade = Grade.RESIT;
		}
	}
	
	//Calculates the total of all the components 
	public int calcOveralMarks() {
		return overalMarks = (int)Math.round(mainComp01 * .30  + mainComp02 * .35 + mainComp03 * .35);
	}
	
	public String getfName() {
		return fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public String getRegNo() {
		return regNo;
	}
	
	public int getMainComp01() {
		return mainComp01;
	}
	
	public int validateUserInput(int marks) {					
		if(!(marks >= 0 && marks <= 100)){
			throw new IllegalArgumentException("Marks should be more than or "
								+ "equals to 0 and less than or equals to 100.");
		}
		return marks;
	}
	public int getMainComp02() {
		return mainComp02;
	}
	
	public int getMainComp03() {
		return mainComp03;
	}
	
	public int getOveralMarks() {
		return overalMarks;
	}
	public Grade getGrade() {
		return grade;
	}
	

	public String getEmail() {
		return email;
	}

	
	@Override
	public String toString() {
			
		return "\n First Name =" + fName + "\n Last Name =" + lName + "\n Registration No. =" + regNo + " \n Email =" + email +" \n Project 01 with In-class test marks ="
				+ mainComp01 +  " \n Coding Assignment with In-class test marks =" + mainComp02 + " \n Project 02 with In-class test marks =" + mainComp03
				+ " \n overall Marks =" + overalMarks +  " \n Grade =" + grade + " \n Average ="+ avg;
		}
	
	@Override
	public int compareTo(Student a) {  //compares this String to the Object "a"
		return this.overalMarks - a.overalMarks;
	}
	

	
	
	
}
