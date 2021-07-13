import java.util.*;
public class Main {
    static int cou;
    public static void count(String s, int ci, int length, String[] arr){
        if(s.length() == length){
            ++cou;
            return;
        }

        for(int i=0 ; i<2; ++i){
            if(ci == 0)
                count(s+arr[i], ci+1, length, arr);
            else{
                char last=s.charAt(ci-1);
                if(i==1 && last == 'b')
                    return;

                else
                    count(s+arr[i], ci+1, length, arr);
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String ab[]={"a","b"};

        for(int i=0; i<n; ++i){
            cou=0;
            int inp=sc.nextInt();
            count("", 0, inp, ab);
            System.out.println("#"+ (i+1) + " : " + cou);   
        }
    }
}