package c17;
import java.util.HashMap;
public class MasterMind {
	public void check(String guess,String solution){
		int hit = 0;
		int pseudoHit = 0;
		HashMap<Character,Integer> letterCount = new HashMap<Character,Integer>();
		for (int i=0;i<guess.length();i++){
			Character curChar = guess.toCharArray()[i];
			if (curChar==solution.toCharArray()[i]){
				hit++;
			}
			else{
				if (letterCount.containsKey(curChar)){
					int count = letterCount.get(curChar);
					count++;
					letterCount.put(curChar, count);
				}
				else{
					letterCount.put(curChar, 1);
				}
			}
		}
		for (Character c:letterCount.keySet()){
			if (solution.indexOf(c)==-1){
				pseudoHit+=letterCount.get(c);
			}
		}
		System.out.println("Hit: "+hit+", PseudoHit: "+pseudoHit);
	}
}
