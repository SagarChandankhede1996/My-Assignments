package stacksQueue20;

import java.util.*;

public class FirstUniqueCharacterinaString387 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabb";
		System.out.println(firstUniqChar(s));
	}
	  public static int firstUniqChar(String s) {
	        int freq[] = new int [26];
	        Queue<Character> q = new LinkedList<>();

	        for(int i = 0 ; i < s.length(); i++){
	            char ch = s.charAt(i);
	            q.add(ch);
	            freq[ch-'a']++;

	            while(!q.isEmpty() && freq[q.peek()-'a'] >1){
	                q.remove();
	            }
	            
	        }
	        return q.isEmpty()?-1 : s.indexOf(q.peek());
	    }
}
