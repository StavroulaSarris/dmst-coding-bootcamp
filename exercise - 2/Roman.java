package number;

public class Roman extends Arabic_System {
	
	private String roman_value;
	
	// a default constructor
	public Roman() {
		
	}//end of constructor
	
	// constructor for a String input
	public Roman(String roman_value) {
		
		super(roman_value);
		this.roman_value = roman_value;
	}//end of constructor
	
	public void setRoman(String roman_value) {
		
		int value2 = romanToDecimal(roman_value);
		setValue(value2);
		this.roman_value = roman_value;
	}
	
	public String getRoman() {
		return this.roman_value;
	}
	
	//method which convert an arabic number to a roman
	public static String dtrmn(int number) {
		
		String letter = "";
		
		int cl = number / 100;
		if (cl != 9 && cl != 4) {
			
			if (cl < 4) {
				
				for(int i = 1; i <= cl; i++) {
					letter = letter + "C";
				}
			} else if (cl < 9 && cl > 4) {
				
				letter = letter + "D";
				for (int i = 1; i <= cl - 5; i++) {
					letter = letter + "C";
				}
			} else if(cl == 10) { 
				
				letter = letter + "M";
			}
		} else if (cl == 4) {
			
			letter = letter + "CD";
			
		} else if (cl == 9) {
			
			letter = letter + "CM";
		}
		
		int cl1 = (number % 100)/10;
		if (cl1 != 9 && cl1 != 4) {
			
			if (cl1 < 4) {
				
				for (int i = 1; i <= cl1; i++) {
					letter = letter + "X";
				}
			} else if (cl1 < 9 && cl1 > 4) {
				letter = letter + "L";
				
				for (int i = 1; i <= cl1 -5; i++) {
					letter = letter + "X";
				}
			
			}
			
		} else if (cl1 == 4) {
			letter = letter + "XL";
		} else if (cl1 == 9) {
			letter = letter + "XC";
		}
		
		int cl2 = (number % 100)%10;
		
		if (cl2 != 9 && cl2 != 4) {
			
			if (cl2 < 4) {
				for (int i = 1; i <= cl2; i++) {
					letter = letter + "I";
				}
			} else if (cl2 < 9 && cl2 > 4) {
				
				letter = letter + "V";
				for (int i = 1; i <= cl2-5; i++) {
					letter = letter + "I";
				}
			}
			
		} else if (cl2 == 4) {
			letter = letter +"IV";
		} else if (cl2 == 9) {
			letter = letter + "IX";
		}
		return letter;
	}//end of the method
}//end of class
