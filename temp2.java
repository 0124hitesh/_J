//List

// recursion
// find #
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

// find #2
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

// remove Nth Node from enf of List
// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         if(head.next == null && n == 1)
//             return null;
        
//         int len = newList(head, n, 1);
//         if(len == n)
//             head = head.next;
            
//         return head;
//     }
    
//     public int newList(ListNode cur, int n, int count){
//         if(cur == null)
//             return count - 1;
        
//         int len = newList(cur.next, n, count + 1);
//         if(len - n == count)
//             cur.next = cur.next.next;
        
//         return len;
//     }
// }