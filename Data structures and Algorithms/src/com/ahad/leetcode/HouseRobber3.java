package com.ahad.leetcode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber3 {

	public static int rob(TreeNode root) {

		int[] rootEI = helper(root);
		return Math.max(rootEI[0], rootEI[1]);

	}

	private static int[] helper(TreeNode root) {
		if (root == null) {
			int[] EI = { 0, 0 };
			return EI;
		}

		int[] left = helper(root.left);
		int[] right = helper(root.right);

		int include = root.val + left[1] + right[1];
		int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		int[] ans = new int[2];
		ans[0] = include;
		ans[1] = exclude;
		return ans;
	}

	static Map<TreeNode, Integer> map = new HashMap<>();
	public static int rob2(TreeNode root) {

		if(root == null) return 0;
		
		if(map.containsKey(root)) return map.get(root);
		
		int sum = root.val;
		
		if(root.left != null) {
			sum += rob2(root.left.left);
			sum += rob2(root.left.right);
		}
		
		if(root.right != null) {
			sum += rob2(root.right.left);
			sum += rob2(root.right.right);
		}
		
		int next_sum = rob2(root.left) + rob2(root.right);
		
		int ans = Math.max(sum, next_sum);
		
		map.put(root, ans);
		
		return ans;

	}

	public static void main(String[] args) {
		// [3,4,5,1,3,null,1]

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);

		System.out.println(rob2(root));

	}
}
