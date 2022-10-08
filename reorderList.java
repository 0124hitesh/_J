// List -> 1, 2, 3, 4, 5,6

// #1 reorder
// 1. Find mid of List (3)
// 2. Reverse second half
//      L1 = 1,2,3
//      L2 = 6,5,4
// 3. Merge list accordingly


// #2 Rotate List 

class Node{
	int val;
	Node next;

	Node(){}

	Node(int val){
		this.val = val;
		this.next = null;
	}

	Node(int val, Node next){
		this.val = val;
		this.next = next;
	}

	Node createList(int[] args){
		Node head = new Node(args[0]);
		Node temp = head;

		for(int i = 1; i < args.length; ++i){
			Node n = new Node(args[i]);
			temp.next = n;
			temp = temp.next;
		}

		return head;
	}

	void printList(Node head){
		Node temp = head;

		while(temp != null){
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	Node reverseList(Node head) {
        
        Node rev = head;
        Node n = head.next;
        rev.next = null;
        
        while(n != null){
            
            Node temp = n;
            n = n.next;
            temp.next = rev;
            rev = temp;
        }
        
        return rev;
    }

    Node mergeList(Node a, Node b){
		Node res = a;
		while(a != null && b != null){
			Node s = a.next;
			Node t = b.next;

			a.next = b;
			b.next = s;

			a = a.next.next;
			b = t;
		}

		return res;
	}

	Node reorder(Node head){
	
		Node s = head;
		Node f = head.next;

		while(f != null && f.next != null){
			s = s.next;
			f = f.next.next;
		}

		Node sec  = reverseList(s.next);
		s.next = null;	
		
		return mergeList(head, sec);
	}

	Node rotateRight(Node head, int k) {
        if(head == null) return null;

        Node tail = head;
		int c = 1;
		while(tail.next != null){
			tail = tail.next;
			++c;
		}
		tail.next = head;
		k = c - k%c + 1;
		
		while(--k > 0) {
            head = head.next;
			tail = tail.next;
		}
		tail.next = null;
				
		return head;
    }

	public static void main(String...args){

		Node ob = new Node();
		Node head = ob.createList(new int[]{1,2,3,4});
		
		Node re = ob.reorder(head);
		ob.printList(re);
	}
}