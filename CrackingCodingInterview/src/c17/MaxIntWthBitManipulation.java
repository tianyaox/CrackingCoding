package c17;

public class MaxIntWthBitManipulation {
	public int max(int a,int b){
		int c = a-b;
		int signA = getSign(a);
		int signB = getSign(b);
		int signC = getSign(c);
		// same:1;
		// not same: 0;
		int ifSameSign = flip(signA^signB);
		int ifNotSameSign = signA^signB;
		int resultA = ifNotSameSign*signA+ifSameSign*signC;
		int resultB = flip(resultA);
		return resultA*a+resultB*b;
	}
	
	// return 1 if positive;
	// return 0 if negative;
	public int getSign(int a){
		return flip(a>>31&0x1);
	}
	public int flip(int a){
		return 1^a;
	}
}
