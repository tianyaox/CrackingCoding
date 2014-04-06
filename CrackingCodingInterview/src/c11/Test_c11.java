package c11;
import static org.junit.Assert.*;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_c11 {
	int[] a;
	SearchInRotatedList n;
	@Before
	public void setup(){
		a = new int[]{5,5,20,0,5};
		n = new SearchInRotatedList();
	}
	
	@Test
	public void searchRotatedListTest(){
		assertEquals(3, n.search(a, 0, 0, a.length-1));
	}
	
}
