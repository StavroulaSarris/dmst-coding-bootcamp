
public class GreekToDecimal {
	
	public static final int [] values = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900,1000};
	public static final String [] digrams = {"Á'","Â'","Ã'","Ä'","Å'","ò'","Æ'","Ç'","È'","É'","Ê'","Ë'","Ì'","Í'","Î'","Ï'","Ð'","Q'","Ñ'","Ó'","Ô'","Õ'","Ö'","×'","Ø'","Ù'","W'",",Á",};
	
	public static int gktd(String greek){
		String letter;
		int decimar = 0;
		int thesi;
		for(int i = 0; i < greek.length(); i= i + 2) {
			letter = greek.substring(i, i + 2);
			thesi = searchInD(letter);
			decimar = decimar + values[thesi];
		}
	
	return decimar;
	}
	public static String dtgrk(int number){
		String letter = "";
		int thesi ;
		int cl = number / 100;
		int search = cl *100;
		
		if (search != 0 ) {
			thesi = searchinV(search);
			letter = letter + digrams[thesi];	
		}
		
		
		int cl1 = (number % 100)/10;
		search = cl1 * 10;
		
		if (search != 0 ) {
			thesi = searchinV(search);
			letter = letter + digrams[thesi];
		}
		
		int cl2 = (number % 100)%10;
		search = cl2;
		if (search != 0 ) {
			thesi = searchinV(search);
			letter = letter + digrams[thesi];
		}
		
		return letter;
		
	}

	public static int searchinV(int val){
		
		int	thesi = -1;
		for (int i = 0; i < values.length; i++ ){
		
			if (val == values[i]) {
				thesi = i;
				break;
			}
		}
		return thesi;
	}
	
	public static int searchInD(String let) {
		
		int thesi = -1;
		for (int i = 0; i < digrams.length; i++){
			if (let.equals(digrams[i])){
				thesi = i;
				break;
			}
		}
		return thesi;
	}
	
}
