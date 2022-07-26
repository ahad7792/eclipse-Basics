package craftsmen;

import java.util.Stack;

public class MaxDepth {
	
	public static int maxDepth(String s) {
		int count = 0;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				st.push(i);
			} else if (s.charAt(i) == '>') {
				if (count < st.size())
					count = st.size();
				st.pop();
			}
		}
		return count;
	}
	    
	static int right = 0;
	static int left = 0;

	public static int maxDepthRecursion(char p, String s) {

		if (p == '<') {
			left++;
		}
		if (p == '>') {
			right++;
		}

		if (s.isEmpty()) {
			return left - right;
		}

		return maxDepthRecursion(s.charAt(0), s.substring(1));

	}

	public static void main(String[] args) {

		String str = "<<<<<<<<<<<>>>>>><<<<<<<<<<<>>>>";

	    //Scanner sc = new Scanner(System.in); String str = sc.nextLine();

		str = str.replaceAll("[^<>]", "");

		System.out.println(maxDepth(str));
		char ch = 0;
		System.out.println(maxDepthRecursion(ch, str));
	}

}
