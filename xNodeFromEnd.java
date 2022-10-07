//List

// recursion
class Solution {
	static ListNode res;
	ListNode xthNodeFromEnd(ListNode head, int x) {
		--x;
		len(head, 1, x);
		
		return res;
	}
	
	int len(ListNode cur, int c, int x){
		if(cur == null) return c - 1;
		
		int l = len(cur.next, c + 1, x);
		if(l - c == x) res = cur; 
		
		return l;
	}
}

// class Solution {
// 	ListNode xthNodeFromEnd(ListNode head, int x) {
// 		ListNode front = head;
// 		for (int i = 1; i < x; i++) {
// 			front = front.next;
// 		}
// 		if (front.next == null) {
// 			return head;
// 		}
// 		while (front.next != null) {
// 			front = front.next;
// 			head = head.next;
// 		}
// 		return head;
// 	}
// }