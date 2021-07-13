import java.util.*;
class Main {

    public static void generateParentheses(int op, int cc, int n, String s){
        if(s.length() == n*2){
            System.out.println(s);
            return;
        }
        if(cc < op)
            generateParentheses(op, cc+1, n, s + ")");
        if(op < n)
            generateParentheses(op+1, cc, n, s + "(" );
        
        
    }
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        generateParentheses(0, 0, n, "");
    }
}