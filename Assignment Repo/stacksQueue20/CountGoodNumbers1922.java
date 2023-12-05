package stacksQueue20;

public class CountGoodNumbers1922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long n = 1;
		System.out.println(countGoodNumbers(n));
	}

	private static long MOD = 1_000_000_007;

	public static int countGoodNumbers(long n) {
		long odd = (n / 2);
		long even = (n + 1) / 2;
		long first = power(5, even) % MOD;
		long second = power(4, odd) % MOD;
		return (int) ((first * second) % MOD);
	}

	private static long power(long x, long n) {
		if (n == 0)
			return 1;

		long temp = power(x, n / 2);

		if (n % 2 == 0) {
			return (temp * temp) % MOD;
		} else {
			return (x * temp * temp) % MOD;
		}
	}
}
