package linkedList;


public class ListNode<T> {
	T data;
	ListNode<T> next,prev;
	int val;
	ListNode(int val) { this.val = val; }
	public ListNode<T> getPrev() {
		return prev;
	}

	public void setPrev(ListNode<T> prev) {
		this.prev = prev;
	}

	ListNode(T data){
		this.data = data;
	}

	public ListNode() {
		// TODO Auto-generated constructor stub
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
}
