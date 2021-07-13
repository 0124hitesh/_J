import java.util.*;
public class Main {

    public static String removePI(String out, String inp, int ci){
        if(ci+1 == inp.length())
            return out;

        char currentChar=inp.charAt(ci);
        char nextChar=inp.charAt(ci+1);
        
        if(currentChar == 'p' && nextChar == 'i')
            out+="3.14";
        else
            out+=String.valueOf(currentChar);
        return removePI(out, inp, ci+1);
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        while(n-- > 0){
            String inp=sc.nextLine();
            System.out.println(removePI("", inp, 0));
        }
    }
}