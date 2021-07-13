import java.util.*;
public class Main {
    public static void asciiSubsequence(String s, String inp, int ci){
        if(ci == inp.length()){
            System.out.print(s + " ");
            return;    
        }

        asciiSubsequence(s, inp, ci+1);
        char c=inp.charAt(ci);
        asciiSubsequence(s + c, inp, ci+1);
        asciiSubsequence(s + (int)c, inp, ci+1);
    }

    public static int count_asciiSubsequence(String s, String inp, int ci){
        if(ci == inp.length()){
            return 1;    
        }
        
        char c=inp.charAt(ci);
        return 
        count_asciiSubsequence(s, inp, ci+1) +
        count_asciiSubsequence(s + c, inp, ci+1) +
        count_asciiSubsequence(s + (int)c, inp, ci+1);
    }

    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();
        asciiSubsequence("", inp, 0);
        System.out.println("\n" + count_asciiSubsequence("",inp, 0));
    }
}
