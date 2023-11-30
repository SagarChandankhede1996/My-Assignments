package recursionCode10;

public class CountCollisionsofMonkeysonaPolygon2550 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		CountCollisionsofMonkeysonaPolygon2550 obj = new CountCollisionsofMonkeysonaPolygon2550();
		System.out.println(obj.monkeyMove(n));
	}

	int modulus = 1000000007;

	public int monkeyMove(int n) {
		int exp = (int)power(2, n) % modulus;
		return (exp - 2 + modulus) % modulus;
	}

	public long power(long a, long b) {
		if (b == 0) {
			return 1;
		}
		long temp = power(a, b / 2);
		long ans = temp * temp % modulus;
		if (b % 2 == 1) {
			ans = ans * a % modulus;
		}
		return ans;
	}

}
