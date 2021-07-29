import java.util.*;
public class Main {
    public static boolean fun(int[] arr, int k){
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<arr.length; ++i){
            if(hm.containsKey(arr[i]))
                if(Math.abs(hm.get(arr[i]) - i) <= k)
                    return true;
            hm.put(arr[i], i);
        }

        return false;
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();
        System.out.println(fun(arr, k));
    }
}