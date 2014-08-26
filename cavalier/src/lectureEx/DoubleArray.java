package lectureEx;

public class DoubleArray {
	public static void main(String[] args){
		int[][] a1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] a2 = {{9,8,7},{6,5,4},{3,2,1}};
		
		System.out.println("add:");
		add(a1,a2);
		System.out.println("minus:");
		minus(a1,a2);
		System.out.println("mul:");
		mul(a1,a2);
		System.out.println("div:");
		div(a1,a2);
		System.out.println("diagonal:");
		diagonal(a1,a2);
	}
	
	public static void add(int[][] a1, int[][] a2){
		for (int i = 0; i<a1.length;i++){
			for (int j = 0; j<a1[i].length;j++) {
				System.out.print(a1[i][j]+a2[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void minus(int[][] a1, int[][] a2){
		for (int i = 0; i<a1.length;i++){
			for (int j = 0; j<a1[i].length;j++) {
				System.out.print((a1[i][j]-a2[i][j])+"\t");
			}
			System.out.println();
		}
	}
	
	public static void mul(int[][] a1, int[][] a2){
		for (int i = 0; i<a1.length;i++){
			for (int j = 0; j<a1[i].length;j++) {
				System.out.print(a1[i][j]*a2[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void div(int[][] a1, int[][] a2){
		for (int i = 0; i<a1.length;i++){
			for (int j = 0; j<a1[i].length;j++) {
				System.out.print(a1[i][j]/a2[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void diagonal(int[][] a1, int[][] a2){
		for (int i = 0; i<a1.length;i++){
			for (int j = 0; j<a1[i].length;j++) {
				if (i==j) System.out.print(a1[i][j]*a2[i][j]+"\t");
				else System.out.print("na"+"\t");
			}
			System.out.println();
		}
	
	}

}
