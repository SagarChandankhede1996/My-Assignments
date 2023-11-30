package linkedList;
import java.util.*;
public class ConvertBinaryNumberinaLinkedListto1290 {
    
	public int getDecimalValue(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head!=null) {
            arr.add(head.val);
            head = head.next;
        }
        int ans = 0;
        for (int i=0; i<arr.size(); i++) {
            ans += ((arr.get(i))*(Math.pow(2, arr.size()-i-1)));
        }
        return ans;
    }
}
