package LangFun;



public class DayOfWeek {
	public static String findDayOfWeek(int[] date){
		int c = 6-(date[2]/100%4)*2;
		int d = (date[1]+date[0]+date[2]+date[2]/4+c)%7;
		
		switch(d){
		case 1: return "Monday";
		case 2: return "Tuesday";
		case 3: return "Wednesday";
		case 4: return "Thursday";
		case 5: return "Friday";
		case 6: return "Saturday";
		default: return "Sunday";
		}

	}
	public static void main(String[] args){
		int[] date = InputParser.parseDate();	//stores dates in formate mm/dd/yyyy
		if (!(date==null)) System.out.print(findDayOfWeek(date));
		else System.out.print("Invalid Input");
		
	}
	
	

}
