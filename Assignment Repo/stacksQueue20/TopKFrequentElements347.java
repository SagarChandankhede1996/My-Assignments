package stacksQueue20;

import java.util.*;

public class TopKFrequentElements347 {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.out.println(Arrays.toString(topKFrequent(nums, k)));
	}
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
          Queue<Integer> pq=new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
          for(int key:hm.keySet()){
              pq.add(key);
          }
          int[] ans=new int[k];
          for(int i=0;i<k;i++){
              ans[i]=pq.poll();
          }
          return ans;
      }
}
