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

	public Main reverseKGroup(Main head, int k) {
        if(head == null)
            return null;
        
        Main temp = head, start = head;
        for(int i=0; i<k; ++i){
            if(temp == null)
                return head;
            
            temp = temp.next;
        }
        
        Main res = reverseList(head, temp);
        start.next = reverseKGroup(temp, k);
        
        return res;
    }

	public Main reverseList(Main head, Main tail) {
        
        Main rev = head;
        Main n = head.next;
        rev.next = null;
        
        while(n != tail){
            
            Main temp = n;
            n = n.next;
            temp.next = rev;
            rev = temp;
        }
        
        return rev;
    }

	public static void main(String...args){
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
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

            head.display(head);
            System.out.println("");
			head.display(head.reverseKGroup(head, k));
		}
	}
}
