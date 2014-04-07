package c11;
import static org.junit.Assert.*;

import java.util.Arrays;

//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Test_c11 {
	int[] a;
	String[] b;
	int[][] c;
	SearchInRotatedList n1;
	SearchWithEmptyIntersperse n2;
	SearchInSortedMatrix n3;
	@Before
	public void setup(){
		a = new int[]{5,5,20,0,5};
		b = new String[]{"a","","b","","","c","d","e",""};
		c = new int[][]{{0,1,2,3},{5,6,7,8},{6,9,10,11},{7,12,13,14}};
		n1 = new SearchInRotatedList();
		n2 = new SearchWithEmptyIntersperse(); 
		n3 = new SearchInSortedMatrix();
	}
	
	@Test
	public void searchRotatedListTest(){
		assertEquals(3, n1.search(a, 0, 0, a.length-1));
	}
	
	@Test
	public void searchWithEmptyIntersperse(){
		assertEquals(6, n2.search(b, "d", 0, b.length-1));
	}
	
	@Test
	public void searchMatrixTest(){
		System.out.println(Arrays.toString(n3.search1(c,11,0,c[0].length-1,0,c.length-1)));

	}
}
