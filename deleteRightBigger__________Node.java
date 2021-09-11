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

	public void deleteNode(Main parent, Main node){
		if(node == null)
			return;
		
		deleteNode(node, node.next);

		if(node.next != null && node.next.val > node.val){
			if(parent != null)
				parent.next = node.next;
			else{
				node.val = node.next.val;
				node.next = node.next.next;
			}
		}
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
            
			head.deleteNode(null, head);
            head.display(head);
		}
	}
}
