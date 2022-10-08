
class Solution {
    Node detectCycle(Node head) {
        if (head == null)
            return null;

        Node s = head, f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                s = head;
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return s;
            }
        }

        return null;
    }

    void removeCycle(Node head) {
        if (head == null) return;

        Node s = head, f = head;

        while (f != null && f.next != null) {

            s = s.next;
            f = f.next.next;
            if (s == f) {
                s = head;
                if (s != f) {
                    while (s.next != f.next) {
                        s = s.next;
                        f = f.next;
                    }
                } 
                else
                    while (s != f.next) f = f.next;

                f.next = null;
                return;
            }
        }

        return;
    }
}