package lectureEx;

public class FahrenheitToCentigrade{
	public static void main(String[] args){
		int opt = Integer.parseInt(args[0]);
		if (opt == 0) {
			System.out.println(convert(Integer.parseInt(args[1])));
		}
		if (opt == 1) {
			System.out.println(add(Integer.parseInt(args[1]),Integer.parseInt(args[2])));
		}

	}

	public static float convert(int f){
		return (f-32)*5.0f/9;
	}

	public static int add(int a, int b){
		return a+b;
	}
}