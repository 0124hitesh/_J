// 430. Flatten a Multilevel Doubly Linked List

class Node {
    Node next;
    Node child;
    Node prev;

    public Node flatten(Node head) {
        if(head == null) return null;
        fla(head);
        return head;
    }

    Node fla(Node head){
        Node c = head.child, n = head.next;

        if(c == null){
            // only CHILD is NULL
            if(n != null) return fla(n);
            
            // both CHILD & NEXT are NULL
            else return head;
        }
    
        head.next = c;
        c.prev = head;

        // to set CHILD node null
        head.child = null;

        // if only NEXT is NULL
        // return last CHILD node
        if(n == null) return fla(c);

        Node retChild = fla(c);
        Node retNext = fla(n);

        retChild.next = n;
        n.prev = retChild;

        // return last node
        return retNext;
    }
}