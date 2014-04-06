package c11;

public class SearchWithEmptyIntersperse {
	public int search(String[] l, String target,int left,int right){
		if (right<left){
			return -1;
		}
		int mid = (left+right)/2;
		if(l[mid].equals("")){
			mid = findNewMid(l,left,right,mid);
			if(mid==-1){	
				return -1;
			}
		}
		System.out.println(mid);
		if (l[mid].equals(target)){
			return mid;
		}
		// String on left side
		if (l[mid].compareTo(target)>0){
			return search(l,target,left,mid);
		}
		
		if (l[mid].compareTo(target)<0){
			return search(l,target,mid+1,right);
		}
		return -1;
		
		
	}
	public int findNewMid(String[] l,int left,int right,int mid){
		int leftMid = -1;
		int rightMid = -1;
		for (int i=mid;i>=left;i--){
			if (!l[i].equals("")){
				leftMid = i;
			}
		}
		for (int i=mid+1;i<=right;i++){
			if (!l[i].equals("")){
				rightMid = i;
			}
		}
		if (rightMid-mid>mid-leftMid){
			return leftMid;
		}
		else if (rightMid-mid<mid-leftMid){
			return rightMid;
		}
		else{
			return -1;
		}
		
	}
}
