package c17;

public class SwapNumsInplace {
	public static void main(String[] args){
		swap(1,2);
		swapBits(1,2);
	}
	public static void swap(int a, int b){
		a = a-b;
		b = b+a;
		a = b-a;
		System.out.println("a: "+a);
		System.out.println("b: "+b);
	}
	public static void swapBits(int a, int b){
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a: "+a);
		System.out.println("b: "+b);
	}
}
