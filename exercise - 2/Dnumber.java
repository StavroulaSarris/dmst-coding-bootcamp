package number;
import java.util.Scanner;

public class Dnumber {
	//Array with greek symbols
	public static final String [] digrams = {"Á'","Â'","Ã'","Ä'","Å'","ò'","Æ'","Ç'","È'","É'","Ê'","Ë'","Ì'","Í'","Î'","Ï'","Ð'",
												"Q'","Ñ'","Ó'","Ô'","Õ'","Ö'","×'","Ø'","Ù'","W'",",Á",};
	//Array with roman symbols
	public static final String [] roman = {"I", "V", "X", "L", "C", "D","M"};
	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		
		System.out.println("Please enter an arithemtic expresion or the enter button to exit!");
		String expr = input.nextLine();
		
		while (expr.length() != 0) {
			
			int a = -1;
			int b = -1; 
			int result = -1;
			String[] array = expr.split(" ");
			
			// recognise the arithmetic system for each expresion's number 
			for (int i = 0; i < array.length; i = i + 2) {
				
				int flag = -1;
				
				for (int j = 0; j < digrams.length; j++) {
					
					if (array[i].equals(digrams[j])) {
						
						flag = 1;
					}
				}
				
				if (flag == 1) { 
					
					Greek grn = new Greek(array[i]);
					if (i == 0) {
						
						a = grn.getValue() ;
					} else if (i == 2) { 
						
						b = grn.getValue();
					}
					
				} else if (flag != 1) { 
					
					String spl = array[i].substring(0,1);
					
					for (int j = 0; j < roman.length; j++) {
						
						if (spl.equals(roman[j])) {
							
							flag = 2;
						}
					}
				}
				
				if (flag == 2) { 
					
					Roman rmnn = new Roman(array[i]);
					
					if (i == 0) {
						
						a = rmnn.getValue();
					} else if (i == 2) {
						
						b =rmnn.getValue() ;
					}
				} else if (flag != 1) {
					
					Arabic_System arbcn = new Arabic_System(array[i]);
					if (i == 0) {
						
						a = arbcn.getValue();
						
					} else if (i == 2) {
						
						b = arbcn.getValue();
						
					}
				}
			}	
			//recognise expresion's symbols	
			if (array[1].equals("*")) {
				
				result = a * b ;
				
			}else if (array[1].equals("/")) {
				
				if(b != 0) {
					
					result = a / b ;
				}
				
			}else if (array[1].equals("+")) {
				
				result = a + b ;
				
			}else if (array[1].equals("-")) {
				
				result = a - b;
			}
			
			//print the result for all Systems!
			if (result > 0 && result <= 1000) { 
				
				System.out.printf("The result at Arabic System is: %d\n",result);
				String ap = Roman.dtrmn(result);
				System.out.printf("The result at Roman System is: %s\n",ap);
				String ap1 = Greek.decToGrk(result);
				System.out.printf("The result at Greek System is: %s\n",ap1);
				
			} else if (result < 0) { 
				
				System.out.println("The result is negative!");
				
			} else if (result > 1000) {
				
				System.out.println("The result is bigger than 1000!");
			}
			
			System.out.println("Please enter an arithemtic expresion or the enter button to exit!");
			expr = input.nextLine();
		}
		if (expr.length() == 0) {
			System.out.println("This is the end of the programm!\n Thank you!");
		}
		
	}

}//end of class
