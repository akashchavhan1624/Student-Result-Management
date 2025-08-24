import java.util.*;
interface ResultOperation {
	public int calculateTotal();
	public double calculatePercentage();
	public String assignGrade();
	void showDetails();
}
abstract class Student {
	int rollNo;
	String name;
	int arr[];
	String courseType;
	public void setDetails(int rollNo, String name, int arr[],String courseType){
		this.rollNo=rollNo;
		this.name=name;
		this.arr=arr;
		this.courseType=courseType;
	}
	public void showDetails(){
		System.out.println("Roll no --> "+rollNo+"\nName --> "+name+"\nCourse --> "+courseType);
		System.out.println("Show Marks ");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
class UGStudent extends Student implements ResultOperation{
	public int calculateTotal(){
		int total=0;
		for(int i=0; i<arr.length; i++){
			total += arr[i];
		}
		return total;
	}
	
	public double calculatePercentage(){
		return (calculateTotal() /(arr.length * 100.0))*100;
	}
	public String assignGrade(){
		double per=calculatePercentage();
		if(per>=40){
			return "PASS";
		}
		else{
			return "FAIL";
		}
	}
	
}
class PGStudent extends Student implements ResultOperation{
	public int calculateTotal(){
		int total=0;
		for(int i=0; i<arr.length; i++){
			total += arr[i];
		}
		return total;
	}
	
	public double calculatePercentage(){
		return (calculateTotal() / (arr.length * 100.0))*100;
	}
	public String assignGrade(){
		double per=calculatePercentage();
		if(per>=50){
			return "PASS";
		}
		else{
			return "FAIL";
		}
	}
}
public class StudentManagementSystemNewApp{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Student");
		int n=sc.nextInt();
		
		ResultOperation s[] = new ResultOperation[n];
		for(int i=0; i<n; i++){
			System.out.println("\nEnter Details of Student "+(i+1));
			System.out.println("Enter Roll Number of Student");
			int rollNo=sc.nextInt();
			sc.nextLine();

			System.out.println("Enter Name of  Student");
			String name=sc.nextLine();
			
			System.out.println("Enter marks of 5 subject");
			int arr[]=new int[5];
			for(int j=0; j<arr.length; j++){
				arr[j]=sc.nextInt();
			}
			sc.nextLine();
			System.out.println("Enter Type UG/PG");
			String type=sc.nextLine();
			if(type.equalsIgnoreCase("UG")){
				UGStudent ug= new UGStudent();
				ug.setDetails(rollNo,name,arr,"UG");
				s[i]=ug;
			}
			else{
				PGStudent pg= new PGStudent();
				pg.setDetails(rollNo,name,arr,"PG");
				s[i]=pg;
			}
			System.out.println("-------------------------------");
		}
		
		System.out.println("\n----Passed Student-----");
		for(int i=0; i<n; i++){
			s[i].calculateTotal();
			s[i].calculatePercentage();
			String grade=s[i].assignGrade();
			
			if(grade.equalsIgnoreCase("PASS")){
				s[i].showDetails();
				System.out.println("Total --> "+s[i].calculateTotal());
				System.out.println("Percentage --> "+s[i].calculatePercentage());
				System.out.println("Grade --> "+grade);
				System.out.println("--------------------------------------------");
			}
		}
		
		System.out.println("\n----Fail Student-----");
		for(int i=0; i<n; i++){
			s[i].calculateTotal();
			s[i].calculatePercentage();
			String grade=s[i].assignGrade();
			
			if(grade.equalsIgnoreCase("FAIL")){
				s[i].showDetails();
				System.out.println("Total --> "+s[i].calculateTotal());
				System.out.println("Percentage --> "+s[i].calculatePercentage());
				System.out.println("Grade --> "+grade);
				System.out.println("--------------------------------------------");
			}
		}
		// Top 3 Student by percentage
		System.out.println("------Top 3 Student-------");
		
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				
				if(s[i].calculatePercentage() <s[j].calculatePercentage()){
					ResultOperation temp=s[i];
					s[i]=s[j];
					s[j]=temp;
				}
			}
		}
		for(int i=0; i<3 && i<n; i++){
			s[i].showDetails();
			System.out.println("Percentage --> "+s[i].calculatePercentage());
		}
	}
}