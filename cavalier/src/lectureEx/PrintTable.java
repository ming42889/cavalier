package lectureEx;

public class PrintTable {
	public static void main(String[] args){
		for (int i = 1; i<21; ++i){
			for (int j = 1; j<21; ++j) {
				System.out.print(i*j+" ");
			}
			System.out.println();
		}
		
	}
}