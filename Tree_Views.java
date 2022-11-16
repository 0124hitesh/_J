import java.util.*;

class Solution {

    class Node{
        Node left, right;
        int data;
    }

	Map<Integer, Integer> m;

    // Left View
	int[] leftView(Node root) {
		m = new HashMap<>();
		lView(0, root);
		
		int[] res = new int[m.size()];
		for(int i = 0; i < res.length; ++i)
			res[i] = m.get(i);
		
		return res;
	}
	
	void lView(int lvl, Node root){
		if(root == null) return;
		
		if(!m.containsKey(lvl)) m.put(lvl, root.data);
		
		lView(lvl + 1, root.left);
		lView(lvl + 1, root.right);
	}


    // Right View
    int[] rightView(Node root) {
        m = new HashMap<>();
         rView(0, root);
         
         int[] res = new int[m.size()];
         for(int i = 0; i < res.length; ++i)
             res[i] = m.get(i);
         
         return res;
     }
     
     void rView(int lvl, Node root){
         if(root == null) return;
         
         if(!m.containsKey(lvl)) m.put(lvl, root.data);
         
         rView(lvl + 1, root.right);
         rView(lvl + 1, root.left);
         
     } 


    // Top View
    Map<Integer, int[]> hm;
    int[] topView(Node root) {
	    hm = new TreeMap<>();
		view(0, 0, root);
		
		int i = 0;
		int[] res = new int[m.size()];
		for(int[] x : hm.values())
			res[i++] = x[1];
		
		return res;
	}
	
	void view(int hor, int ver, Node root){
		if(root == null) return;
		
		if(!m.containsKey(hor)) {
            hm.put(hor, new int[]{ver, root.data});
        }
		else if(hm.get(hor)[0] > ver){
			hm.put(hor, new int[]{ver, root.data});
		}
		
		view(hor - 1, ver + 1, root.left);
		view(hor + 1, ver + 1, root.right);
	}
}