import java.util.Scanner;

public class NumberPallindrom {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int temp = p;
		int r;
		int sum = 0;
		
		while (temp != 0) {
			r = temp % 10;
			sum = sum * 10 + r;
			temp = temp / 10;
		}
		
		if ( sum == p) {
			System.out.println(p + " is a pallindrom number");
		}
		else {
			System.out.println(p + " is not a pallindrome number");
		}

	}

}
