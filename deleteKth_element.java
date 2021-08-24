import java.util.*;

public class Main {
	private class Node {
		int data;
		Node next;

	}

	private Node head;
	private Node tail;
	private int size;

	// private Node tamp = head;

	public int getfirst() throws Exception {
		if (size == 0) {
			throw new Exception(" LL is empty");

		}

		return this.head.data;
	}

	public int getlast() throws Exception {
		if (size == 0) {
			throw new Exception(" LL is empty");

		}

		return this.tail.data;
	}

	public int getat(int k) throws Exception {
		if (size == 0) {
			throw new Exception(" LL is empty");

		}
		if (k < 0 || k >= size) {
			throw new Exception(" Invailed index");

		}

		Node temp = this.head;
		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	public void display() {

		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	public void addLast(int item) {
		Node nn = new Node();

		nn.data = item;
		nn.next = null;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;

		} else {
			this.tail.next = nn;
			this.tail = nn;
			this.size++;
		}
	}

	public void addfirst(int item) {
		Node nn = new Node();

		nn.data = item;
		nn.next = null;
		if (this.size == 0) {
			nn.next = this.head;
			this.head = nn;
			this.tail = nn;
			this.size++;

		} else {
			nn.next = this.head;
			this.head = nn;
			this.size++;
		}
	}

	private Node getnode(int k) throws Exception {
		if (size == 0) {
			throw new Exception(" LL is empty");

		}
		if (k < 0 || k >= size) {
			throw new Exception(" Invailed index");

		}

		Node temp = this.head;
		for (int i = 1; i <= k; i++) {
			temp = temp.next;
		}

		return temp;
	}

	public void addat(int k, int item) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		if (k == 0) {
			addfirst(item);
		} else if (k == this.size) {
			addLast(item);
		} else {
			Node nn = new Node();

			nn.data = item;
			nn.next = null;

			Node nm1 = getnode(k - 1);
			Node np1 = getnode(k);
			nm1.next = nn;
			nn.next = np1;
			this.size++;

		}

	}

	public int removefirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		int tamp = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return tamp;
	}

	public int removelast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}
		int tamp = this.tail.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sm2 = getnode(this.size - 2);

			sm2.next = null;
			tail = sm2;
			this.size--;

		}
		return tamp;
	}

	public int removeat(int k) throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is empty");
		}

		if (k < 0 || k >= size) {
			throw new Exception(" Invailed index");

		}

		if (k == 0) {
			return removefirst();
		} else if (k == this.size - 1) {
			return removelast();
		} else {
			Node nn = new Node();

			Node nm1 = getnode(k - 1);
			nn = nm1.next;
			Node np1 = nn.next;
			nm1.next = np1;
			this.size--;
			return nn.data;
		}

	}
	static int sk;
	static int ans;
	public int kthformlast(int k) {
		sk = k;
		ele(head);
		return ans;
		// Write your Code  here 
	}
	public void ele(Node node){
		if(node == null)
			return;

		ele(node.next);

		if(sk-- == 1)
			ans = node.data;
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		Main list = new Main();
		int item = sc.nextInt();
		while (item != -1) {
			list.addLast(item);
			item = sc.nextInt();
			

		}

		int n = sc.nextInt();
		
		 System.out.println(list.kthformlast(n));
	}
}
