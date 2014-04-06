package c11;

public class SearchInRotatedList {
	public int search(int[] s,int target, int left, int right){
		int mid = (left+right)/2;
		if(s[mid]==target){
			return mid;
		}
		if (right<left){
			return -1;
		}
		if (s[left]<s[mid]){
			if (s[left]<target && target<s[mid]){
				return search(s,target,left,mid);
			}
			else{
				return search(s,target,mid+1,right);
			}
		}
		else if (s[left]>s[mid]){
			if (s[right]>target && target > s[mid+1]){
				return search(s,target,mid+1,right);
			}
			else{
				return search(s,target,left,mid);
			}
		}
		else if (s[left]==s[mid]){
			if (s[right]!=s[mid]){
				return search(s,target,mid+1,right);
			}
			else {
				int leftResult = search(s,target,left,mid);
				if (leftResult==-1){
					return search(s,target,mid+1,right);
				}
				else {
					return leftResult;
				}
				
			}
		}
		return -1;
	}
}
