
public class EulersCoprime {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("Number " + i + " : " + cofactors(i));
		}

	}
	
	static int cofactors (int num) {
		int r = num;
		for (int i = 2; i * i <= num; i++) {
			
			while (num % i == 0) {
				num = num/i;
				r = r - r/i;
			}
			
		}
		
		if (num > 1) {
			r = r - r/num;
		}
		return r;
	}

}
