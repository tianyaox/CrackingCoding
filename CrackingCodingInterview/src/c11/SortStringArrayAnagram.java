package c11;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class SortStringArrayAnagram {
	public static void main(String[] args){
		SortStringArrayAnagram a = new SortStringArrayAnagram();
		String[] sl = {"apple","pleap","qoww","pplea","qqwrwerqwer","wwoq"};
		System.out.println(Arrays.toString(a.sortUsingAnagram(sl)));
	}
	public String[] sortUsingAnagram(String[] s){
		HashMap<String,ArrayList<String>> h = new HashMap<String,ArrayList<String>>();
		for(int i=0;i<s.length;i++){
			String curSSort = sortString(s[i]);
			if (h.containsKey(curSSort)){
				h.get(curSSort).add(s[i]);
			}
			else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(s[i]);
				h.put(curSSort, al);
			}
		}
		int index = 0;
		for(String key:h.keySet()){
			ArrayList<String> strings = h.get(key);
			for(String curS:strings){
				s[index] = curS;
				index++;
			}
		}
		return s;
	}
	public String sortString(String s){
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return String.valueOf(c);
	}
}
