package c11;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	TwoSequenceSort n4;
	ArrayList<TwoSequenceSort.WTHT> circus;
	
	@Before
	public void setup() {
		a = new int[] { 5, 5, 20, 0, 5 };
		b = new String[] { "a", "", "b", "", "", "c", "d", "e", "" };
		c = new int[][] { { 0, 1, 2, 3 }, { 5, 6, 7, 8 }, { 6, 9, 10, 11 },
				{ 7, 12, 13, 14 } };
		n1 = new SearchInRotatedList();
		n2 = new SearchWithEmptyIntersperse();
		n3 = new SearchInSortedMatrix();
		n4 = new TwoSequenceSort();
		TwoSequenceSort.WTHT wh1 = n4.new WTHT(1,2);
		TwoSequenceSort.WTHT wh2 = n4.new WTHT(2,5);
		TwoSequenceSort.WTHT wh3 = n4.new WTHT(3,1);
		TwoSequenceSort.WTHT wh4 = n4.new WTHT(4,3);
		TwoSequenceSort.WTHT wh5 = n4.new WTHT(5,4);
		circus = new ArrayList<TwoSequenceSort.WTHT>();
		circus.add(wh5);
		circus.add(wh3);
		circus.add(wh2);
		circus.add(wh1);
		circus.add(wh4);
	}

	@Test
	public void searchRotatedListTest() {
		assertEquals(3, n1.search(a, 0, 0, a.length - 1));
	}

	@Test
	public void searchWithEmptyIntersperse() {
		assertEquals(6, n2.search(b, "d", 0, b.length - 1));
	}

	@Test
	public void searchMatrixTest() {
//		System.out.println(Arrays.toString(n3.search1(c, 11, 0,
//				c[0].length - 1, 0, c.length - 1)));

	}
	
	@Test
	public void twoSequenceSort(){
//		System.out.println(circus);
		ArrayList<TwoSequenceSort.WTHT> result = n4.twoSequenceSort(circus);
		for (int i=0;i<result.size();i++){
			System.out.println(result.get(i).WT+" "+result.get(i).HT);	
		}
		
	}
}
