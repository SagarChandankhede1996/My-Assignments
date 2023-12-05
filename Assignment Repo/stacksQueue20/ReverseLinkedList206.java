package stacksQueue20;

import java.util.Stack;

import linkedList.ListNode;

public class ReverseLinkedList206 {
	public static void main(String[] args) {
		
	}
	public ListNode reverseList(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        ListNode result = new ListNode();
        head=result;
        int n=stack.size();
        for(int i=0;i<n;i++){
            result.next= new ListNode(stack.pop());
            result=result.next;
        }
        return head.next;
    }
}
