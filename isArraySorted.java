import java.util.*;
class Main {

    public static boolean isArrySorted(int[] arr, int size, int ci){

        if(ci + 1 < size){
            if(arr[ci] <= arr[ci+1])
                isArrySorted(arr, size, ci+1);
            else
                return false;
        }

        return true;
    }
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
        int arr[]=new int[n];
        for(int i=0; i<n; ++i)
            arr[i]=sc.nextInt();

        System.out.println(isArrySorted(arr, n, 0));
    }
}
