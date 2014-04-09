package c17;

public class CountZerosInANFactorial {
	// Loop from 1 to n, see if they contains how many 5s;
	public int countZerosInANFactorial(int n){
		int count = 0;
		for (int i=1;i<=n;i++){
			while (i%5==0){
				count++;
				i/=5;
			}
		}
		return count;
	}
}
