import java.util.*;
public class Main {

    public static String moveX(String notX, String x, String inp, int ci){
        if(ci == inp.length())
            return (notX + x);

            char c=inp.charAt(ci);
            if(c == 'x')
                x+=String.valueOf(c);
            else 
                notX+=String.valueOf(c);
            
        
        return moveX(notX, x, inp, ci+1);
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();

        System.out.println(moveX("", "", inp, 0));
    }
}
