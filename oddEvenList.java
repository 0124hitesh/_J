import java.util.*;

class Main {
	int val;
    Main next;
	Main(){}
    Main(int val) { 
		this.val = val; 
	}

	public void display(Main node){
		if(node == null)
			return;

		System.out.print(node.val + " ");
		display(node.next);
	}

    public Main oddEvenList(Main node) {
        
        Main odd = null;
        Main even = null;
        Main evPt = null;
        Main odPt = null;

        while(node != null){

            if(node.val % 2 == 0){
                if(evPt == null)
                    even = evPt =node;
                else
                    even = even.next = node;
            }
            else{
                if(odd == null)
                    odd = odPt = node;
                else
                    odd = odd.next = node;
            }
            node = node.next;
        }
        if(even != null && even.next != null)
            even.next = null;
        if(odPt != null)
            odd.next = evPt;

        return odPt != null ? odPt : evPt;
    }

	public static void main(String...args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		if(n != 0){
			int x = sc.nextInt();
            
			Main head = new Main(x);
			Main temp = head;

			while(--n > 0){
				x = sc.nextInt();
				Main ob = new Main(x);
				temp.next = ob;
				temp = ob;
			}

            Main t = head.oddEvenList(head);
			head.display(t);
		}
	}
}
