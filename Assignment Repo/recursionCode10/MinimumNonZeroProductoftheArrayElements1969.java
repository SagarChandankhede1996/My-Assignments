package recursionCode10;

public class MinimumNonZeroProductoftheArrayElements1969 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 2;
		MinimumNonZeroProductoftheArrayElements1969 obj =new MinimumNonZeroProductoftheArrayElements1969();
		System.out.println(obj.minNonZeroProduct(p));
		
	}
	 public int modulus = 1000000007;
	    public int minNonZeroProduct(int p) {
	        if (p == 1) {
	        	return 1;
	        }
	        
	        long mx = (long)(Math.pow(2, p)) - 1;
	        long sm = mx - 1;
	        long n = sm/2;
	        long sum = rec(sm, n);
	        
	        return (int)(sum * (mx % modulus) % modulus); 
	    }
	    
	    public long rec(long val, long n) {
	        if (n == 0) return 1;
	        if (n == 1) return (val % modulus);
	        
	        long newVal = ((val % modulus) * (val % modulus)) % modulus;
	        
	        if (n % 2 != 0) {
	            return ((rec(newVal, n/2) % modulus) * (val % modulus)) % modulus;
	        }
	        
	        return rec(newVal, n/2) % modulus;
	    }
}
