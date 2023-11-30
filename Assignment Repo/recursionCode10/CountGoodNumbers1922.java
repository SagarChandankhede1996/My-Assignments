package recursionCode10;

public class CountGoodNumbers1922 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		System.out.println(countGoodNumbers(n));
	}

	static int modulus = 1000000007;

	public static int countGoodNumbers(long n) {
		long even = (n + 1) / 2;
		long odd = n / 2;
		return (int) ((power(5, even)) * (power(4, odd)) % modulus);
	}

	public static long power(long x, long even) {
		long temp = 1;
		
		if (even == 0) {
			return 1;
		}	
		temp = power(x, even / 2);
		if (even % 2 == 0) {
			return (temp * temp) % modulus;
		} else {
			return (x * temp * temp) % modulus;
		}
	}
}
