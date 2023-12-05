package stacksQueue20;

import java.util.Stack;

public class BaseballGame628 {

	public static void main(String[] args) {
		String[] ops = {"5","2","C","D","+"};
		System.out.println(calPoints(ops));
	}
	  public static int calPoints(String[] operations) {
	        Stack<Integer> stack = new Stack<>();

	        for (String s : operations) {
	            if (s.equals("+")) {
	                stack.push(stack.peek() + stack.elementAt(stack.size()-2));
	            }
	            else if (s.equals("D")) {
	                stack.push(stack.peek() * 2);
	            }
	            else if (s.equals("C")) {
	                stack.pop();
	            }
	            else {
	                stack.push(Integer.parseInt(s));
	            }

	        }


	        int sum = 0;

	        for (int i : stack) {
	            sum += i;
	        }

	        return sum;
	    }
}
