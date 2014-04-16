package binaryTreeTranverse;

import java.util.ArrayList;

public class Inorder {
	public ArrayList<Integer> traverseMain(TreeNode head){
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(head,result);
		return result;
	}
	public void traverse(TreeNode n,ArrayList<Integer> arr){
		if (n==null) return;
		traverse(n.left,arr);
		arr.add(n.val);
		traverse(n.right,arr);
	}
}
