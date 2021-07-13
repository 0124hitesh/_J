import java.util.*;
public class Main {
    public static String printString(String s, String inp, int ci){
        if(ci == inp.length())
            return s;
        
        char currentChar=inp.charAt(ci);
        if(ci > 0){
            char previousChar=inp.charAt(ci-1);
            if(currentChar == previousChar)
                s+= "*" + String.valueOf(currentChar);
            else
                s+=String.valueOf(currentChar);
        }
        else
             s+=String.valueOf(currentChar);

        return printString(s, inp, ci+1);
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();

        System.out.println(printString("", inp, 0));
    }
}
