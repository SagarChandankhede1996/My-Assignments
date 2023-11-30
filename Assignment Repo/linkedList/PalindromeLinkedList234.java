package linkedList;

public class PalindromeLinkedList234 {

	public boolean isPalindrome(ListNode head) {
		ListNode temp = new ListNode();
		ListNode a = head;
		ListNode pre = null;

		while (a != null) {
			temp = new ListNode(a.val);
			temp.next = pre;
			pre = temp;
			a = a.next;
		}

		while (pre != null) {
			if (pre.val != head.val)
				return false;
			pre = pre.next;
			head = head.next;
		}

		return true;
	}
}
