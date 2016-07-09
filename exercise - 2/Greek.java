package number;

public class Greek extends Arabic_System {
	
	private String greek_value;
	public static final int [] values = {1,2,3,4,5,6,7,8,9,10,20,30,40,50,60,70,80,90,100,200,300,400,500,600,700,800,900,1000};
	public static final String [] digrams = {"Á'","Â'","Ã'","Ä'","Å'","ò'","Æ'","Ç'","È'","É'","Ê'","Ë'","Ì'","Í'","Î'","Ï'","Ð'",
			"Q'","Ñ'","Ó'","Ô'","Õ'","Ö'","×'","Ø'","Ù'","W'",",Á",};
	
	//a default constructor
	public Greek() {
		
	}//end of constructor
	
	//constructor for greek number
	public Greek(String greek_value) {
		
		super(greek_value,values,digrams);
		this.greek_value = greek_value;
	}//end of constructor
	
	
	public void setgValue(String greek_value) { 
		
		int value2 = greekToDecimal(greek_value,values,digrams);
		setValue(value2);
		this.greek_value = greek_value;
	}
	
	
	public String getgValue() {
		
		return this.greek_value;
	}
	
	// method to convert a roman number to a greek one
	public static String decToGrk (int value) {
		
		String letter = "";
		int position ;

		int cl = value / 100;
		int search = cl *100;
		
		if (search != 0 ) {
			
			position = searchinV(search);
			letter = letter + digrams[position];	
		}
		
		
		int cl1 = (value % 100)/10;
		search = cl1 * 10;
		
		if (search != 0 ) { 
			
			position = searchinV(search);
			letter = letter + digrams[position];
		}
		
		int cl2 = (value % 100)%10;
		search = cl2;
		
		if (search != 0 ) {
			
			position = searchinV(search);
			letter = letter + digrams[position];
		}
		
		return letter;
	}//end of decToGrk method
	
	//method which finds the number's position  
	public static int searchinV(int val){
		
		int	position = -1;
		for (int i = 0; i < values.length; i++ ) {
	
			if (val == values[i]) {
				
				position = i;
				break;
			}
		}
		return position;
	}//end of searchinV method

}//end of class
