package assignment7;

public class Student {
	private String firstName;
	private String lastName;
	private int studentIdNumber;
	private int attemptedCredits;
	private int passingCredits;
	private double totalGradeQualityPoints;
	private double bearBucksBalance;
	/**
	 * 
	 * @param firstName students' first names
	 * @param lastName students' last name
	 * @param studentIdNumber students' id
	 */
	public Student(String firstName, String lastName, int studentIdNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentIdNumber = studentIdNumber;
		attemptedCredits = 0;
		passingCredits =0;
		totalGradeQualityPoints = 0.0;
		bearBucksBalance = 0.0;
	}
	
	public String getFullName(){
		String name = firstName + " " + lastName;
		return name;
		
	}
	public int getId() {
		return studentIdNumber;
		
	}
	public int getTotalAttemptedCredits() {
		return attemptedCredits;
	}
	public int getTotalPassingCredits() {
		return passingCredits;
	}
	public double calculateGradePointAverage() {
		double average = totalGradeQualityPoints / attemptedCredits;
		return average;
	}
	public void submitGrade(double grade, int credits) {
		attemptedCredits += credits;
		totalGradeQualityPoints += grade*credits;
		if(grade>= 1.7) {
			passingCredits += credits;
		}
	}
	public String getClassStanding() {
		if(passingCredits < 30) {
			return "First Year";
		}
		if(passingCredits >= 30 && passingCredits <60) {
			return "Sophomore";
		}
		if(passingCredits >= 60 && passingCredits <90) {
			return "Junior";
		}
		else {
			return "Senior";		
		}
	}
	public boolean isEligibleForPhiBetaKappa() {
		if(passingCredits >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		}
		if(passingCredits >= 75 && calculateGradePointAverage()>=3.80) {
			return true;
		}
		else {
			return false;
		}
	}
	public void depositBearBucks(double amount) {
		bearBucksBalance += amount;
	}
	public void deductBearBucks(double amount) {
		bearBucksBalance -= amount;
	}
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	public double cashOutBearBucks() {
		if(bearBucksBalance >10) {
			double cash = bearBucksBalance;
			bearBucksBalance = 0;
			return cash -10 ;
		}
		else {
			bearBucksBalance = 0;
			return bearBucksBalance;
		}
	}
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		if(isHyphenated) {
			//lastName = lastName + "-"+ otherParent.lastName;
			Student legacy = new Student(firstName,lastName + "-"+ otherParent.lastName, id);
			legacy.depositBearBucks(otherParent.cashOutBearBucks()+this.cashOutBearBucks());
			return legacy;
		}
		else {
			Student legacy = new Student(firstName,lastName, id);
			return legacy;
		}
	}
	public String toString() {
		return this.getFullName() + "; id: " + this.getId();
	}
	
}
