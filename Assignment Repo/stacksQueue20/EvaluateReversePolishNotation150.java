package stacksQueue20;

import java.util.*;

public class EvaluateReversePolishNotation150 {

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		System.out.println(evalRPN(tokens));
	}
	public static int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0;i<tokens.length;i++) {
            switch(tokens[i]) {
                case "+" : {int x = stack.pop();
                            int y = stack.pop();
                            stack.push(Integer.valueOf(x+y));
                            break;
                           }
                case "-" : {int x = stack.pop();
                            int y = stack.pop();
                            stack.push(Integer.valueOf(y-x));
                            break;
                           }
                case "*" : {int x = stack.pop();
                            int y = stack.pop();
                            stack.push(Integer.valueOf(x*y));
                            break;
                           }
                case "/" : {int x = stack.pop();
                            int y = stack.pop();
                            stack.push(Integer.valueOf(y/x));
                            break;
                           }
                default:
                    stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
