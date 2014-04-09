package c17;

public class MaxIntWthBitManipulation {
	public int max(int a,int b){
		int signA = getSign(a);
		int signB = getSign(b);
		// same:1;
		// not same: 0;
		int ifSameSign = flip(signA^signB);
		
		
	}
	
	// return 1 if positive;
	// return 0 if negative;
	public int getSign(int a){
		return flip(a<<31&0x1);
	}
	public int flip(int a){
		return 1^a;
	}
}
