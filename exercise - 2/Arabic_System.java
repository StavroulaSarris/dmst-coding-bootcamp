package number;

public class Arabic_System {
	
	private int arabic_value;
	
	// a default constructor
	public Arabic_System() {
		
	}
	//Constructor for a String input
	public Arabic_System(String arabic_value) { 
		
		int flag = -1; 
		
		//Check if this String is a roman number
		for (int i = 0; i < Dnumber.roman.length; i = i + 2) {
			
			if (arabic_value.substring(0,1).equals(Dnumber.roman[i])) {
				
				this.arabic_value = romanToDecimal(arabic_value);
				flag = 1;
			}
		}
		
		if(flag == -1) {
			
			this.arabic_value = Integer.parseInt(arabic_value);
		}
	}
	
	//Constructor for a greek number
	public Arabic_System(String gValue,int [] values,String [] digrams) {
		
		this.arabic_value = greekToDecimal(gValue, values, digrams);
	}
	
	
	
	public void setValue(int arabic_value) { 
		
		this.arabic_value = arabic_value;
	}
	
	public int getValue() {
		
		return this.arabic_value;
	}
	
	//method to convert a greek number to a arabic number
	
	public int greekToDecimal(String grkV,int [] values,String [] digrams) {
		
		String letter;
		int decimal = 0;
		int position;
		
		for(int i = 0; i < grkV.length(); i = i + 2) {
			
			letter = grkV.substring(i, i + 2);
			position = searchInD(letter, digrams);
			decimal = decimal + values[position];
		}
	
		return decimal;
		
	}
	
	//method to convert a roman number to a arabic one
	
	public int romanToDecimal(String rmnV) {
		
		char letter;
		int decimar = 0;
		int previous = 0;
		int diaf, dec ;
		
		for(int i = rmnV.length()-1; i >= 0; i--) {
			 
			letter = rmnV.charAt(i);
			 
			 switch(letter) {
			 case 'I':
				 dec = 1;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 1;
				 break;
				 
			 case 'V':
				 dec = 5;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 5;
				 break;
				 
			 case 'X':
				 dec = 10;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 10;
				 break;
				 
			 case 'L' :
				 dec = 50;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 50;
				 break;
				 
			 case 'C' :
				 dec = 100;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 100;
				 break;
				 
			 case 'D':
				 dec = 500;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 500;
				 break;
				 
			 case 'M':
				 dec = 1000;
				 diaf = rtdn(dec,previous);
				 if (diaf == 1) {
					 decimar -= dec;
				 } else {
					 decimar += dec;
				 }
				 previous = 1000;
				 break;
			}
			
		}
		
		return(decimar);
		
	}
	
	// a method to find special cases in roman System
	// now is the number that we have to add and previous the number we added before
	
	public int rtdn(int now, int before) {
		int diaf ;
		
		if (before <= now) {
			
			diaf = -1;
			return (diaf);
			
		} else if(before > now) {
			diaf = 1;
			return(diaf);
			
		}else{
			return(1);
		}
		
	}
	
	//method to find the position of a greek number 
	public int searchInD(String let,String [] digrams) {
		
		int position = -1;
		
		for (int i = 0; i < digrams.length; i++) {
			if (let.equals(digrams[i])) {
				
				position = i;
				break;
			}
		}
		
		return position;
	}
	
}

