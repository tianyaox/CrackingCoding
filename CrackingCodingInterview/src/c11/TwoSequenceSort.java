package c11;

import java.util.ArrayList;
import java.util.Collections;

public class TwoSequenceSort {
	public class WTHT implements Comparable {
		int WT;
		int HT;

		public WTHT(int w, int h) {
			this.WT = w;
			this.HT = h;
		}

		public int compareTo(Object s) {
			WTHT second = (WTHT) s;
			// compare WT first, if the same, compare HT
//			if (this.WT != second.WT) {
//				return ((Integer) this.WT).compareTo(second.WT);
//			} else {
//				return ((Integer) this.HT).compareTo(second.HT);
//			}
			if (this.HT != second.HT) {
				return ((Integer) this.HT).compareTo(second.HT);
			} else {
				return ((Integer) this.WT).compareTo(second.WT);
			}
		}

		public boolean isBefore(WTHT second) {
			if (this.HT < second.HT && this.WT < second.WT) {
				return true;
			} else
				return false;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<WTHT> twoSequenceSort(ArrayList<WTHT> circus) {
		// sort according to WT first as defined in WTHT class
		Collections.sort(circus);
		for (int i=0;i<circus.size();i++){
			System.out.println(circus.get(i).WT+" "+circus.get(i).HT);	
		}
		System.out.println();
		
		ArrayList<WTHT>[] solutions = new ArrayList[circus.size()];
		longestIncreasingSub(circus, 0, solutions);
		ArrayList<WTHT> bestResult = null;
		for (int i = 0; i < solutions.length; i++) {
			bestResult = betterSolution(bestResult, solutions[i]);
		}
		return bestResult;
	}

	public void longestIncreasingSub(ArrayList<WTHT> circus, int curIndex,
			ArrayList<WTHT>[] solutions) {
		if (curIndex < 0 || curIndex > circus.size()-1)
			return;
		WTHT curElement = circus.get(curIndex);
		ArrayList<WTHT> curBest = null;
		for (int i = 0; i < curIndex; i++) {
			if (circus.get(i).isBefore(curElement)) {
				curBest = betterSolution(solutions[i], curBest);
			}
		}
		ArrayList<WTHT> newSolution = new ArrayList<WTHT>();
		if (curBest != null) {
			newSolution.addAll(solutions[curIndex - 1]);
		}
		newSolution.add(curElement);
		solutions[curIndex] = newSolution;
		longestIncreasingSub(circus, curIndex + 1, solutions);
	}

	public ArrayList<WTHT> betterSolution(ArrayList<WTHT> first,
			ArrayList<WTHT> second) {
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		if (first.size() >= second.size()) {
			return first;
		} else
			return second;
	}

}
