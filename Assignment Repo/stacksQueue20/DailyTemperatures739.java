package stacksQueue20;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temperatures = {73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
	}
	public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.empty() && temperatures[i] > temperatures[st.peek()]){
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            ans[st.peek()] = 0;
            st.pop();
        }
        return ans;
    }
}
