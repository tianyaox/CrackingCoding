package binaryTreeTranverse;
import org.junit.Test;
import org.junit.Before;
//import org.junit.Assert.*;

public class TestForTraverse {
	Preorder p;
	Inorder i;
	Postorder po;
	TreeNode head;
	
	@Before
	public void setup(){
		
//		Set the test binary tree 
		TreeNode one = new TreeNode(1);
		TreeNode zero = new TreeNode(0);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode ten = new TreeNode(10);
		head = new TreeNode(7);
		head.left = one;
		head.right = nine;
		one.left = zero;
		one.right = three;
		three.left = two;
		three.right = five;
		five.left = four;
		five.right = six;
		nine.left = eight;
		nine.right = ten;
		
		p = new Preorder();
		i = new Inorder();
		po = new Postorder();
	}
	
	@Test
	public void testForPreorder(){
		System.out.println(p.traverseMain(head).toString());
	}
	@Test
	public void testForInorder(){
		System.out.println(i.traverseMain(head).toString());
	}
	@Test
	public void testForPosrorder(){
		System.out.println(po.traverseMain(head).toString());
	}
	
}
