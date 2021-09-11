import java.util.*;

class Main {
    class Node{
        int val;
        Node next;
        Node(){}
        Node(int val) { 
            this.val = val; 
        }
    }

    static Scanner sc = new Scanner(System.in);


        public Node createList(int n){

			if(n == 0)
				return null;
				
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

        int num(Node node, int k){
            if(node == null)
                return 0;

            if(node.next == null)
                return k*10 + node.val;

            
            k = k*10 + node.val;

            return num(node.next, k);
        }

	public static void main(String...args){
		
        int a = sc.nextInt();
        int b = sc.nextInt();

        Main ob = new Main();
        Node l1 = ob.createList(a);
        Node l2 = ob.createList(b);

        String x = String.valueOf(ob.num(l1, 0) + ob.num(l2, 0));
        if(x.equals("0"))
			return;
            
        for(char c : x.toCharArray())
            System.out.print(c + " ");
	}
}
