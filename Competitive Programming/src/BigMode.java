import java.util.Scanner;

public class BigMode {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		
		System.out.println(bigmod(a, b, M));
		
	}
	
	public static int bigmod(int a, int b, int M) {
		
		if(b == 0) {
			return 1 % M;
		}
		
		int x = bigmod(a, b/2, M);
		x = (x * x) % M;
		
		if (b % 2 == 1) {
			x = (x * a) % M;
		}
		
		return x;
	}

}
