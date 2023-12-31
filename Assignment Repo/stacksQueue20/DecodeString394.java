package stacksQueue20;

import java.util.Stack;

public class DecodeString394 {
	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));
	}
	 public static String decodeString(String s) {
	        String res = "";
	        Stack<Integer> counts = new Stack();
	        Stack<String> result = new Stack();
	        int index = 0;
	        while (index < s.length()){
	            if (Character.isDigit(s.charAt(index))){
	                int count = 0;
	                while (Character.isDigit(s.charAt(index))){
	                    count = 10 * count + (s.charAt(index) - '0');
	                    index += 1;
	                }
	                counts.push(count);
	            } else if (s.charAt(index) == '[') {
	                result.push(res);
	                res = "";
	                index += 1;
	            } else if (s.charAt(index) == ']') {
	                StringBuilder temp = new StringBuilder(result.pop());
	                int count = counts.pop();
	                for (int i = 0; i < count; i++) {
	                    temp.append(res);
	                }
	                res = temp.toString();
	                index += 1;
	            } else {
	                res += s.charAt(index);
	                index += 1;
	            }
	        }
	        return res;
	    }
}
