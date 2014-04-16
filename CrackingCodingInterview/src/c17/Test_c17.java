package c17;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class Test_c17 {
	FindUnsortedSequence n1;
	int[] n1List;
	
	
	
	@Before
	public void setup(){
		n1 = new FindUnsortedSequence();
		n1List = new int[]{1,2,3,4,5,3,7,9,18,16,17,18,19,20,21};
	}
	
	@Test
	public void testForN1(){
		System.out.println(n1.findUnsortedSequence(n1List).toString());
	}
	
}
