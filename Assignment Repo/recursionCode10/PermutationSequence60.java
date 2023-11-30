package recursionCode10;

import java.util.*;

public class PermutationSequence60 {

	public static void main(String[] args) {
		int n = 3, k = 3;
		System.out.println(getPermutation(n, k));

	}

	public static String getPermutation(int n, int k) {
		int fact = 1;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
			fact = fact * i;
		}
		k = k - 1;
		fact = fact / n;
		String ans = "";

		while (true) {

			ans = ans + list.get(k / fact);
			list.remove(k / fact);
			if (list.size() == 0)
				break;
			k = k % fact;
			fact = fact / list.size();

		}
		return ans;
	}

}
