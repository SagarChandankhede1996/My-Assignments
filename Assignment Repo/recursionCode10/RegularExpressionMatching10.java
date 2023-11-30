package recursionCode10;

public class RegularExpressionMatching10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ab", p = ".*";
		//String s = "aa", p = "a";
		System.out.println(isMatch(s, p));
	}
	public static boolean isMatch(String s, String p) {
        // Base case
       if (p.length() == 0) {
          
           return s.length() == 0; 
       }
       boolean firstMatch = (s.length() > 0 && 
            (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
      
       if (p.length() >= 2 && p.charAt(1) == '*') {
		  return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2)); 
       }
       return firstMatch && isMatch(s.substring(1), p.substring(1)); 
   }

}
