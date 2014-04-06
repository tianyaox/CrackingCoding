package c11;
import static org.junit.Assert.*;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_c11 {
	int[] a;
	String[] b;
	SearchInRotatedList n1;
	SearchWithEmptyIntersperse n2; 
	@Before
	public void setup(){
		a = new int[]{5,5,20,0,5};
		b = new String[]{"a","","b","","","c","d","e",""};
		n1 = new SearchInRotatedList();
		n2 = new SearchWithEmptyIntersperse(); 
	}
	
	@Test
	public void searchRotatedListTest(){
		assertEquals(3, n1.search(a, 0, 0, a.length-1));
	}
	
	@Test
	public void searchWithEmptyIntersperse(){
		assertEquals(6, n2.search(b, "d", 0, b.length-1));
		
	}
	
}
