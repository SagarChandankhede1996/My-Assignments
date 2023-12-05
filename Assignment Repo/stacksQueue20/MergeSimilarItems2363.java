package stacksQueue20;

import java.util.*;

public class MergeSimilarItems2363 {

	public static void main(String[] args) {
		int[][] items1 = {{1,1},{4,5},{3,8}};
		int[][] items2 = {{3,1},{1,5}};
		System.out.println(mergeSimilarItems(items1, items2));
	}
	
	 public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
	        List<List<Integer>> ans = new ArrayList<>();
	        Map<Integer,Integer> map = new TreeMap<>();
	        for(int[] i : items1){
	            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
	        }
	        for(int[] i : items2){
	            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
	        }
	        for(Map.Entry<Integer,Integer> i : map.entrySet()){
	            ans.add(Arrays.asList(i.getKey(),i.getValue()));
	        }
	        return ans;
	    }
}
