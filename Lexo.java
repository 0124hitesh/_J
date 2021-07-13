import java.util.*;
class Main {
    
    public static void printLexo(int start, int end) {
        if(start > end)
            return;

        int temp=0;
        if(start == 0)
            temp=1;

        System.out.print(start + "");

        for(int i=temp; i<10; ++i)
            printLexo(start*10 + i, end);
    }
    public static void main(String args[]) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printLexo(0,n);
    }
}
