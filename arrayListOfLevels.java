import java.util.*;
public class Main {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		Main m = new Main();
		BinaryTree bt1 = m.new BinaryTree();
		System.out.println(bt1.levelArrayList());
	}

	private class BinaryTree {
		private class Node {
			int data;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public BinaryTree() {
			this.root = this.takeInput(null, false);
		}

		public Node takeInput(Node parent, boolean ilc) {

			int cdata = scn.nextInt();
			Node child = new Node();
			child.data = cdata;
			this.size++;

			// left
			boolean hlc = scn.nextBoolean();

			if (hlc) {
				child.left = this.takeInput(child, true);
			}

			// right
			boolean hrc = scn.nextBoolean();

			if (hrc) {
				child.right = this.takeInput(child, false);
			}

			// return
			return child;
		}

		public ArrayList<ArrayList<Integer>> levelArrayList() {

			// write your code here
			ArrayList<ArrayList<Integer>> ll = new ArrayList<>();
			levelList(ll, 0, root);
			return ll;
		}

		public void levelList(ArrayList<ArrayList<Integer>> ll, int level, Node curNode){
			if(curNode == null)
				return;

			if(level == ll.size())
				ll.add(new ArrayList<Integer>());

			ll.get(level).add(curNode.data);

			levelList(ll, level + 1, curNode.left);
			levelList(ll, level + 1, curNode.right);
		}

	}

}
