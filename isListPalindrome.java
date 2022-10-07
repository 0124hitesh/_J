class Solution {
    public boolean isPalindrome(ListNode list) {
        if(list == null || list.next == null) return true;

        ListNode s = list;
        ListNode pre = null;
		ListNode f = list;
		
		while(f != null && f.next != null){
            f = f.next.next;

            ListNode temp = s;
            s = s.next;
            temp.next = pre;
            pre = temp;
		}
        if(f != null) s = s.next;
        
        while(pre != null){
            if(pre.val != s.val) return false;

            pre = pre.next;
            s = s.next;
        }
		return true;	
    }
}