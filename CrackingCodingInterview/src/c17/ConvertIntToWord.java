package c17;

import java.util.ArrayList;

public class ConvertIntToWord {

	public static void main(String[] args) {
		String[] digit = new String[] { "", "One", "Two", "Three", "Four",
				"Five", "Six", "Seven", "Eight", "Nine" };
		String[] tenish = new String[] { "Ten", "Eleven", "Twelve", "Thirteen",
				"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Ninteen" };
		String[] moreThanTenish = new String[] { "Twenty", "Thirty", "Fourty",
				"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		System.out.println(ConvertIntToWord.convert(912, digit, tenish,
				moreThanTenish));
		System.out.println(ConvertIntToWord.convertMain(10000912));
	}

	public static String convertMain(int i) {
		String[] digit = new String[] { "", "One", "Two", "Three", "Four",
				"Five", "Six", "Seven", "Eight", "Nine" };
		String[] tenish = new String[] { "Ten", "Eleven", "Twelve", "Thirteen",
				"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Ninteen" };
		String[] moreThanTenish = new String[] { "Twenty", "Thirty", "Fourty",
				"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		ArrayList<Integer> intPieces = new ArrayList<Integer>();
		ArrayList<String> wordPieces = new ArrayList<String>();
		String result = "";
		if (i == 0)
			return "Zero";
		while (i > 0) {
			intPieces.add(i % 1000);
			i /= 1000;
		}
		for (Integer curI : intPieces) {
			wordPieces.add(convert(curI, digit, tenish, moreThanTenish));
		}
		for (int index = wordPieces.size() - 1; i >= 0; i--) {
			String curS = wordPieces.get(index);
			if (!result.equals(""))
				result += ", ";
			if (!curS.equals(""))
				result += curS;
			result += getSuffix(index);
		}
		return result;
	}

	public static String getSuffix(int i) {
		if (i == 3)
			return "Billion";
		else if (i == 2)
			return "Million";
		else if (i == 1)
			return "Thousand";
		else
			return "";
	}

	public static String convert(int i, String[] digit, String[] tenish,
			String[] moreThanTenish) {
		ArrayList<Integer> intPieces = new ArrayList<Integer>();

		if (i == 0)
			return "";
		String result = "";
		while (i > 0) {
			intPieces.add(i % 10);
			i /= 10;
		}
		if (intPieces.size() < 2) {
			result = digit[intPieces.get(0)];
		} else {
			String tens;

			if (intPieces.get(1) == 0) {
				if (intPieces.get(0) == 0) {
					tens = "";
				} else {
					tens = digit[intPieces.get(0)];
				}
			} else if (intPieces.get(1) == 1) {
				tens = tenish[intPieces.get(0)];
			} else {
				if (digit[intPieces.get(0)].equals("")) {
					tens = moreThanTenish[intPieces.get(1) - 2];
				} else {
					tens = moreThanTenish[intPieces.get(1) - 2] + "-"
							+ digit[intPieces.get(0)];
				}
			}
			if (intPieces.size() == 2) {
				result = tens;
			}
			if (intPieces.size() == 3) {
				String hundreds = digit[intPieces.get(2)] + " " + "Hundred";
				if (tens.equals("")) {
					result = hundreds;
				} else {
					result = hundreds + " and " + tens;
				}
			}

		}
		return result;
	}

}
