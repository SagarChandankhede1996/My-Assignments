package stacksQueue20;

import java.util.HashMap;

public class FindLuckyIntegerinanArray1394 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {2,2,3,4};
		System.out.println(findLucky(arr));
	}
	 public static int findLucky(int[] arr) 
	    {
	        HashMap<Integer,Integer> hmap=new HashMap<>();
	        for(int i:arr)
	            hmap.put(i,hmap.getOrDefault(i,0)+1);
	        int max=-1;
	        for(Integer key:hmap.keySet())
	        {
	            if(hmap.get(key)==key && key>max)
	                max=key;
	        }
	        return max;
	    }
}
