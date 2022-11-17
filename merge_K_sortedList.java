class Solution {
    class ListNode{
        ListNode next;
        int val;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return kl(lists, 0, lists.length - 1);
    }

    public ListNode kl(ListNode[] lists, int s, int e){
        if(e - s == 1) return ml(lists[s], lists[e]);
        if(e == s) return lists[s];
        
        int m = s + (e - s)/2;        
        return ml(kl(lists, s, m), kl(lists, m + 1, e));
    }

    // merge 2 sorted lists
    ListNode ml(ListNode a, ListNode b){
        if(a == null) return b;
        if(b == null) return a;
        
        if(a.val < b.val){
            a.next = ml(a.next, b);
            return a;
        }
        else{
            b.next = ml(a, b.next);
            return b;
        }
    }
    
    
}