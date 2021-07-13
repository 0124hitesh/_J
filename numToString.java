import java.util.*;
public class Main {
    public static String numToString(String s, int inp){
        if(inp < 10)
            return inp+s;
        
        return numToString(inp%10 + s, inp/10);

    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int inp=sc.nextInt();

        System.out.println(numToString("", inp));
    }
}
