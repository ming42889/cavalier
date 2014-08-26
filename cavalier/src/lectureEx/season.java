package lectureEx;

public class season{
	public static void main(String[] args){
		season s = new season();
		System.out.println(s.checkSeason(args[0]));
	}

	String checkSeason(String mon){
		switch (Integer.parseInt(mon)%11) {
			case 0: ;
			case 1: ;
			case 2: return "winter";
			case 3: ;
			case 4: return "spring";
			case 5: ;
			case 6: ;
			case 7: ;
			case 8: return "summer";
			case 9: ;
			case 10: return "fall";
			default: return "error";
		}
	}
}