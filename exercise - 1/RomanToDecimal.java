
public class RomanToDecimal {
	
	public static int rtd (String roman) {
		char letter;
		int decimar = 0;
		int previous = 0;
		int diaf, dec ;
		for(int i = roman.length()-1; i >= 0; i--) {
			 letter = roman.charAt(i);
			 
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
	public static int rtdn(int now, int before){
		int diaf ;
		if (before <= now){
			diaf = -1;
			return (diaf);
		} else if(before > now) {
			diaf = 1;
			return(diaf);
		}else{
			return(1);
		}
		
	}
	public static String dtrmn(int number){
		
		String letter = "";
		
		int cl = number / 100;
		if (cl != 9 && cl != 4){
			if (cl < 4) {
				for(int i = 1; i <= cl; i++){
					letter = letter + "C";
				}
			} else if (cl < 9 && cl > 4){
				letter = letter + "D";
				for (int i = 1; i <= cl - 5; i++){
					letter = letter + "C";
				}
			} else if(cl == 10){
				letter = letter + "M";
			}
		} else if (cl == 4){
			letter = letter + "CD";
		} else if (cl == 9){
			letter = letter + "CM";
		}
		
		int cl1 = (number % 100)/10;
		if (cl1 != 9 && cl1 != 4) {
			if (cl1 < 4) {
				for (int i = 1; i <= cl1; i++){
					letter = letter + "X";
				}
			} else if (cl1 < 9 && cl1 > 4){
				letter = letter + "L";
				for (int i = 1; i <= cl1 -5; i++){
					letter = letter + "X";
				}
			
			} 
		} else if (cl1 == 4) {
			letter = letter + "XL";
		} else if (cl1 == 9) {
			letter = letter + "XC";
		}
		
		int cl2 = (number % 100)%10;
		if (cl2 != 9 && cl2 != 4){
			if (cl2 < 4) {
				for (int i = 1; i <= cl2; i++){
					letter = letter + "I";
				}
			} else if (cl2 < 9 && cl2 > 4) {
				letter = letter + "V";
				for (int i = 1; i <= cl2-5; i++){
					letter = letter + "I";
				}
			}
		} else if (cl2 == 4) {
			letter = letter +"IV";
		} else if (cl2 == 9) {
			letter = letter + "IX";
		}
		return letter;
	}

}
