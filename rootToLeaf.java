import java.util.*;
public class Main {
    static Scanner sc= new Scanner(System.in);

    static class Bt{
        Bt left;
        Bt right;
        int val;
    }
    
    static Bt inputTree(){

       int val = sc.nextInt();
       Bt node = new Bt();
       node.val = val;

       boolean x = sc.nextBoolean();
       if(x == true)
            node.left = inputTree();

        x = sc.nextBoolean();
        if(x == true)
            node.right = inputTree();

        return node;
    }

    static boolean sumNum(Bt root, int target, List<Integer> l){
        target = target - root.val;
        l.add(root.val);

        if(root.left == null && root.right == null){
            if(target == 0){
                for(int x : l)
                    System.out.print(x + " ");
            }
            
            return false;
        }
        
        boolean left = false, right = false;
        if(root.left != null)
            left = sumNum(root.left, target, l);
        if(root.right != null)
            right = sumNum(root.right, target, l);

        l.remove(0);
        
        return (left || right);
    }

    public static void main(String args[]) {
        
        Bt node = inputTree();
        int target = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        sumNum(node, target, l);
    }
}