package lectureEx;

public class CountVowals {
	public static void main(String[] args){
		int[] count = countVowals(args[0]);
		System.out.println("a = "+count[0]+",e = "+count[1]+
			", i = "+count[2]+", o = "+count[3]+", u = "+count[4]);
		
	}
	
	public static int[] countVowals(String s) {
		int[] count = {0,0,0,0,0};
		char x;
		for (int i = 0;i<s.length();i++){
			x = s.charAt(i);
			switch(x){
				case 'a': ;
				case 'A': count[0]++; break;
				case 'e': ;
				case 'E': count[1]++; break;
				case 'i': ;
				case 'I': count[2]++; break;
				case 'o': ;
				case 'O': count[3]++; break;
				case 'u': ;
				case 'U': count[4]++;
			}
			
		}
		
		return count;
	}
}
