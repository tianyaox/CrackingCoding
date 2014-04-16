package c17;
import java.util.Arrays;

public class FindUnsortedSequence {
	public class Result{
		int left;
		int right;
		public String toString(){
			return "Left: "+left+" Right: "+right;
		}
	}
	public int findSortedLeft(int[] list){
		if (list.length<2) return 0;
		int last = list[0];
		int result = 0;
		for (int i=1;i<list.length;i++){
			if (list[i]>=last){
				last = list[i];
				result = i;
			}
			else break;
		}
		return result;
	}
	public int findSortedRight(int[] list){
		if (list.length<2) return 0;
		int last = list[list.length-1];
		int result = list.length-1;
		for (int i=list.length-2;i>=0;i--){
			if (list[i]<=last){
				last = list[i];
				result = i;
			}
			else break;
		}
		return result;
	}
	
	public int maxInList(int[] list){
		int last = list[0];
		for (int i:list){
			if (i>last) last=i;
		}
		return last;
	}
	public int minInList(int[] list){
		int last = list[0];
		for (int i:list){
			if (i<last) last=i;
		}
		return last;
	}
	
	public int shrinkLeft(int[] list,int left, int min){
		for (int i=left;i>=0;i--){
			if (list[i]>min){
				continue;
			}
			else{
				return i+1;
			}
		}
		return 0;
	}
	
	public int shrinkRight(int[] list, int right, int max){
		for (int i=right;i<list.length;i++){
			if (list[i]<max){
				continue;
			}
			else{
				return i-1;
			}
		}
		return list.length;
	}
	
	public Result findUnsortedSequence(int[] list){
		Result r = new Result();
		int left = findSortedLeft(list);
		int right = findSortedRight(list);
		if (right-left<=1) return null;
		int maxNum = maxInList(Arrays.copyOfRange(list, left+1, right+1));
		int minNum = minInList(Arrays.copyOfRange(list, left+1, right+1));
		int newLeft = shrinkLeft(list,left,minNum);
		int newRight = shrinkRight(list,right,maxNum);
		r.left = newLeft;
		r.right = newRight;
		return r;
	}
}
