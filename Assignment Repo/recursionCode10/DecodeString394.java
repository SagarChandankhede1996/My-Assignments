package recursionCode10;

public class DecodeString394 {
	
	public static void main(String[] args) {
//			Input: s = "3[a]2[bc]"
//			Output: "aaabcbc"
//
//			Input: s = "3[a2[c]]"
//			Output: "accaccacc"
//
//			Input: s = "2[abc]3[cd]ef"
//			Output: "abcabccdcdcdef"
		System.out.println(decodeString("2[abc]3[cd]ef"));
	}
	static int i = 0;
	public static String decodeString(String s) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		String tmp_string = "";
		
		while (i < s.length()) {
			char c = s.charAt(i);
			i++;

			if (c == '[') {
				tmp_string = decodeString(s); 
				for (int j = 0; j < count; j++) {
					sb.append(tmp_string);
				}
				count = 0;
			} else if (c == ']') {  
				break;
			} else if (Character.isAlphabetic(c)) {
				sb.append(c);
			} else {
				count = count * 10 + c - '0';
			}
		}

		return sb.toString();
	}
}
