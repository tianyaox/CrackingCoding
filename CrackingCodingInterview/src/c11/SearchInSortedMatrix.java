package c11;

public class SearchInSortedMatrix {
	// try to do a naive binary search
	public int[] search(int[][] matrix,int target,int left,int right,
			int up,int down){
		
		if (left>right || up>down){
			return new int[]{-1,-1};
		}
		int rowMid = (up+down)/2;
		int colMid = (left+right)/2;
//		int rowMid1 = rowMid+1;
//		int colMid1 = colMid+1;
		if (matrix[rowMid][colMid]==target){
			return new int[]{rowMid,colMid};
		}
		if (matrix[rowMid][colMid]>target){
			int[] result1;
			int[] result2;
			result1 = search(matrix,target,left,colMid-1,up,rowMid-1);
			if (result1.equals(new int[]{-1,-1})){
				result2 = search(matrix,target,left,colMid-1,rowMid,down);
				if (result2.equals(new int[]{-1,-1})){
					return search(matrix,target,colMid,right,up,rowMid-1);
				}
				else {
					return result2;
				}
			}
			else{
				return result1;
			}
		}
		if (matrix[rowMid][colMid]<target){
			int[] result1;
			int [] result2;
			result1 = search(matrix,target,colMid+1,right,rowMid+1,down);
			if (result1.equals(new int[]{-1,-1})){
				result2 = search(matrix,target,colMid+1,right,up,rowMid);
				if (result2.equals(new int[]{-1,-1})){
					return search(matrix,target,left,colMid,rowMid+1,down);
				}
				else{
					return result2;
				}
			}
			else {
				return result1;
			}
		}
		return new int[]{-1,-1};
	}
	// do binary search on diagonal
	public int[] search1(int[][] matrix, int target, int left,int right,int up,int down ){
		System.out.println("left: "+left+" right: "+right+" up: "+up+" down: "+down);
		int[] notFound = new int[]{-1,-1};
		if (left>right || up>down){
			return notFound;
		}
		// search diagonal
		int diagLength = Math.min(right-left, down-up);
		int diagLeft = left;
		int diagUp = up;
		int diagRight = left+diagLength;
		int diagDown = up+diagLength;
		while (diagLeft<diagRight && diagUp<diagDown){
			if (matrix[diagUp][diagLeft]==target){
				return new int[]{diagUp,diagLeft};
			}
			if (matrix[diagUp][diagLeft]>target){
				break;
			}
			diagLeft++;
			diagUp++;
		}
		if (matrix[diagUp][diagLeft]==target){
			return new int[]{diagUp,diagLeft};
		}
//		if (matrix[diagUp][diagLeft]>target){
//			break;
//		}
		
		System.out.println("diagLeft: "+diagLeft);
		System.out.println("diagUp: "+diagUp);
		
		// search two quadrants
		int[] result1 = search1(matrix, target, diagLeft,right,up,diagUp-1);
		if (result1.equals(notFound)){
			return search1(matrix, target,left,diagLeft-1,diagUp,down);
		}
		else{
			return result1;
		}
//		return notFound;
	}
}
