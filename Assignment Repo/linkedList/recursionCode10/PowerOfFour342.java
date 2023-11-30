package recursionCode10;

public class PowerOfFour342 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 16;
		System.out.println(isPowerOfFour(n));
	}
	public static boolean isPowerOfFour(int n) {
	       if(n==0){
	       return false; 
	    }
	    if (n==1){
	        return true ;
	    }
	    if (n%4!=0){
	        return false;
	    }
	    return isPowerOfFour(n/4);
	}
}
