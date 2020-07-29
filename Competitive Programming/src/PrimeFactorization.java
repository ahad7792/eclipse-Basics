import java.util.Scanner;

public class PrimeFactorization {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		sc.close();
		
		getPrimeFactors(num);

	}

	private static void getPrimeFactors(long num) {
		
		for(long i = 2; i <= num/i; i++) {
			
			while(num % i == 0) {
				
				System.out.println("Number: " + num);
				num = num/i;
				System.out.println("Factor: " + i);
				
			}
			
		}
		
		if(num > 1) {
			
			System.out.println("Factor: " + num);
			
		}
		
	}

}
