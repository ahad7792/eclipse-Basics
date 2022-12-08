package com.ahad.leetcode;

import java.util.List;
import java.util.ArrayList;

public class LeafSimilarTrees {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list(root1,list1);
        list(root2,list2);
        if(list1.size()!=list2.size())
            return false;
        return list1.equals(list2);
    }
    public void list(TreeNode root, List<Integer> newList)
    {
         if(root==null) return ;
         if(root.left==null && root.right==null)
            newList.add(root.val);
         list(root.left,newList);
         list(root.right,newList);
    }

}
