import java.util.*;
public class MainMethod {
	
	public static void main(String[] args) {
		
		Matrix m = new Matrix();
		
		boolean status = true;
		m.populateDataInMatrix();
		Scanner scanner = new Scanner(System.in);
		while(status) {
			
			System.out.println("Main Application");
			System.out.println("1. View Next State");
			System.out.println("2. Restore default state of matrix");
			System.out.println("3. press 3 to EXIT");
			System.out.println("Enter your choice:");
			int value = Integer.parseInt(scanner.nextLine());
			
			switch(value) {
				
			case 1:
				m.next();
				break;
				
			case 2:
				m.populateDataInMatrix();
				break;
				
			case 3:
				status = false;
				System.out.println("Thank you..");
				break;
				
			default:
				System.out.println("Wrong option!!!!");
				break;
			}
			
		}
		
	}
}
