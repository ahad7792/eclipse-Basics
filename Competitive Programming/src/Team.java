import java.util.Scanner;

public class Team {

	public static void main(String[] args) {
		int[] arr = new int[3];
		int k = 0;
		int l = 0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i ++) {
			for(int j = 0; j < 3; j++) {
				arr[j] = sc.nextInt();
			}
			k = arr[0] + arr[1] + arr[2];
			if (k > 1) {
				l++;
			}
		}
		System.out.println(l);
		
	}

}
