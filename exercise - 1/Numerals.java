import java.util.Scanner;

public class Numerals {
	
	public static final String [] digrams = {"Á'","Â'","Ã'","Ä'","Å'","ò'","Æ'","Ç'","È'","É'","Ê'","Ë'","Ì'","Í'","Î'","Ï'","Ð'","Q'","Ñ'","Ó'","Ô'","Õ'","Ö'","×'","Ø'","Ù'","W'",",Á",};
	public static final char [] roman = {'I', 'V', 'X', 'L', 'C', 'D','M'};
	public static final String [] symbols = {"+","-","*","/"};
	private static Scanner input;
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		
		System.out.println("Please enter an arithemtic expresion or enter to exit!");
		String expr = input.nextLine();
		
		while (expr.length() != 0){
			int a = -1;
			int b = -1; 
			int result = -1;
			String[] array = expr.split(" ");
			
			for (int i = 0; i < array.length; i = i + 2){
				int flag = -1;
				
				
				for (int j = 0; j < digrams.length; j++) {
					if (array[i].equals(digrams[j])){
						flag = 1;
					}
				}
				if (flag == 1){
					if (i == 0) {
						a = GreekToDecimal.gktd(array[i]);
					} else if (i == 2){
						b = GreekToDecimal.gktd(array[i]);
					}
				} else if (flag != 1) {
					char spl = array[i].charAt(0);
					for (int j = 0; j < roman.length; j++) {
						if (spl == roman[j]){
							flag = 2;
						}
					}
				}
				
				if (flag == 2) {
					if (i == 0) {
						a = RomanToDecimal.rtd(array[i]);
					} else if (i == 2){
						b = RomanToDecimal.rtd(array[i]);
					}
				} else if (flag != 1){
					
					if (i == 0) {
						a = Integer.parseInt(array[i]);
					} else if (i == 2){
						b = Integer.parseInt(array[i]);
					}
				}
			}
			
			switch(array[1]) {
			
			case "*":
				result = a * b ;
				break;
			case "/":
				if(b != 0) {
				result = a / b ;
				break;
				}
			case "+":
				result = a + b ;
				break;
			case "-":
				result = a - b;
				break;
			}
			
			if (result > 0 && result <= 1000) {
				System.out.printf("The result at Arabic System is:%d\n",result);
				String ap = RomanToDecimal.dtrmn(result);
				System.out.printf("The result at Roman System is:%s\n",ap);
				String ap1 = GreekToDecimal.dtgrk(result);
				System.out.printf("The result at Greek System is:%s\n",ap1);
			} else if (result < 0){
				System.out.println("The result is negative!");
			} else if (result > 1000){
				System.out.println("The result is bigger than 1000!");
			}
			System.out.println("Please enter an arithemtic expresion or the enter button to exit!");
			expr = input.nextLine();
		
		}
		if (expr.length() == 0){
			System.out.println("This is the end of the programm!\n Thank you!");
		}

	}
}
