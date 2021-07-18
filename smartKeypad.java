import java.util.*;
public class Main{
    public static void printCom(String inp, int ci, String s, String[] table){
        if(ci == inp.length()){
            System.out.println(s);
            return;
        }

        String num = table[inp.charAt(ci) - '0'];
        for(char x : num.toCharArray())
            printCom(inp, ci + 1, s + x, table);
        
    }
    public static void main(String...args){
        Scanner sc=new Scanner(System.in);
        String inp=sc.nextLine();

        String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
        printCom(inp, 0 ,"", table);
    }
}