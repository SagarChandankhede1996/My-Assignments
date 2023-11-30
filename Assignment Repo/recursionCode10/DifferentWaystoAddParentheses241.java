package recursionCode10;

import java.util.*;

public class DifferentWaystoAddParentheses241 {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String expression = "2-1-1";
		String expression = "2*3-4*5";
		System.out.println(diffWaysToCompute(expression));
	}

	public static List<Integer> diffWaysToCompute(String expression) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			
			if (ch == '+' || ch == '-' || ch == '*') {
				List<Integer> left = diffWaysToCompute(expression.substring(0, i));
				List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
				
				for (int l : left)
					for (int r : right) {
						if (ch == '+')
							result.add(l + r);
						else if (ch == '-')
							result.add(l - r);
						else
							result.add(l * r);
					}
			}

		}
		if (result.size() == 0)
			result.add(Integer.valueOf(expression));
		return result;
	}
	
}
