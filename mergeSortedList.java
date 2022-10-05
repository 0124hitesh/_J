import java.util.*;

class Main {
    class Node{
        int val;
        Node next;
        Node(){}
        Node(int val) { 
            this.val = val; 
        }
        Node(int val, Node next) { 
            this.val = val; 
            this.next = next; 
        }
    }

    static Scanner sc = new Scanner(System.in);

        public Node createList(int n){

			if(n == 0){
				return null;
			}
			
            int x = sc.nextInt();
                
            Node head = new Node(x);
            Node temp = head;

            while(--n > 0){
                x = sc.nextInt();
                Node ob = new Node(x);
                temp.next = ob;
                temp = ob;
            }

            return head;
        }

        public void display(Node node){
            if(node == null)
                return;
    
            System.out.print(node.val + " ");
            display(node.next);
        }

        Node mergeTwoLists2(Node firstList, Node secondList) {
        
            if(firstList == null) return secondList;
             
             Node a = new Node(0, firstList);
             Node b = secondList;
             
             while(a.next != null && b != null){
                 if(a.next.val <= b.val) a = a.next;
                 else {
                     Node n = new Node(a.next.val, a.next.next);
                     a.next.val = b.val;
                     a.next.next = n;
                     b = b.next;
                 }
             }
             if(b == null) return firstList;
     
             a.next = b;
             return firstList;
         }
        public Node mergeTwoLists(Node l1, Node l2) {
        
            if(l1 == null)
                return l2;
            if(l2 == null)
                return l1;
            
            Node t1 = l1;
            Node t2 = l2;
            
            while(t2 != null){
                
                while(t1.next !=null && t2.val > t1.val){
                    t1 = t1.next;
                }
                
                if(t1.next == null && t2.val > t1.val){
                    Node n = new Node(t2.val, null);
                    t1.next = n;
                }
                else{
                    int t1_val = t1.val;
                    t1.val = t2.val;
                    Node n = new Node(t1_val, t1.next);
                    t1.next = n;
                    
                }
                
                t2 = t2.next;
            }
            
            return l1;
        }

        
	public static void main(String...args){
		
        Main ob = new Main();

		int t = sc.nextInt();
		while(t-- > 0){
			int a = sc.nextInt();
			Node l1 = ob.createList(a);

			int b = sc.nextInt();
			Node l2 = ob.createList(b);

			ob.display(ob.mergeTwoLists(l1, l2)); 
			System.out.println(""); 
		}      
	}
}
