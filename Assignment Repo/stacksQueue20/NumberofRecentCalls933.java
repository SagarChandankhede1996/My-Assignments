package stacksQueue20;

import java.util.*;

public class NumberofRecentCalls933 {
	int count;

    Queue<Integer> request;  
    public void RecentCounter() {
        request = new LinkedList<>();
         count = 0;
    }
    
    public int ping(int t) {
           
         request.add(t);
         while(!request.isEmpty() && request.peek() < t - 3000){
             request.poll(); 
             count--;     
         }
            count++;
         
          return count;
    }
}
