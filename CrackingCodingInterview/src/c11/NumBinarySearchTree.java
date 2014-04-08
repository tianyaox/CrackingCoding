package c11;

public class NumBinarySearchTree {
	public class TreeNode{
		int data;
		TreeNode left, right;
		int leftCount;
		public TreeNode(int d){
			this.data = d;
			
		}
		
		public void insert(int d){
			// insert to left
			if (d<=data){
				if (this.left==null){
					TreeNode newLeft = new TreeNode(d);
					this.left = newLeft;
				}
				else{
					this.left.insert(d);
				}
				this.leftCount++;
			}
			// insert right
			else {
				if (this.right==null){
					TreeNode newRight = new TreeNode(d);
					this.right = newRight;
				}
				else{
					this.right.insert(d);
				}
			}
		}
		
		public int getRank(int d){
			if (d==this.data){
				return this.leftCount;
			}
			else if (d<this.data){
				if (this.left==null){
					return -1;
				}
				return this.left.getRank(d);
			}
			else{
				if (this.right==null){
					return -1;
				}
				return this.leftCount+1+this.right.getRank(d);
			}
		}
	}
}
