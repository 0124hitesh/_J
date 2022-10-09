/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        fla(head);
        return head;
    }

    Node fla(Node head){
        Node c = head.child, n = head.next;

        if(head.child == null){
            if(n != null) return fla(n);
            else
                return head;
        }

        head.next = head.child;
        head.child.prev = head;

        Node retChild = fla(head.child);
        Node retNext = fla(n);

        retChild.next = n;
        n.prev = retChild;

        return retNext;
    }
}