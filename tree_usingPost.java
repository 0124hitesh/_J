import java.util.*;
public class Main {
	
	public class Node {	
		int val;
		Node left;
		Node right;
	}
	
	public static Scanner sc = new Scanner(System.in); 
	
	Map<Integer, Integer> hm;
	int z;
	public Node construct(int in[], int inStrt,int inEnd, int post[], int postStrt, int postEnd)
	{
		z = in.length - 1;
        hm = new HashMap<>();
        for(int i=0; i<in.length; ++i)
            hm.put(in[i], i);
        
        return bt(0, in.length - 1, post);
	}
	
	public Node bt(int l, int r, int[] post){
        if(l > r)
            return null;
        
        int curVal = post[z--];
        Node root = new Node();
		root.val = curVal;
                
        int ind = hm.get(curVal);
        
        root.right = bt(ind + 1, r, post);
        root.left = bt(l, ind - 1, post);
        
        return root;
    }

	public void display(Node node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		String str ="";
		if (node.left == null) {
			str += "END";
		} else {
			str += node.left.val;
		}

		str += " => " + node.val + " <= ";

		if (node.right == null) {
			str += "END";
		} else {
			str += node.right.val;
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}
	
	public static void main(String[] args) {
		Main obj = new Main();
		int m = sc.nextInt();
		int[] post = new int[m];
		for(int i=0; i<m; i++) {
		    post[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		int[] in = new int[n];
		for(int i=0; i<n; i++) {
			in[i] = sc.nextInt();
		}
		Node root = obj.construct( in, 0, n-1, post, 0, n-1);
		obj.display(root);
	}
}