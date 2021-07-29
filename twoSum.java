import java.util.*;
public class Main {
    public static int[] twoSum(int[] nums, int target) {
        int[] x= {-1, -1};
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; ++i){
            mp.put(nums[i], i);
        }

        boolean[] arr = new boolean[n];

        for(int i=0; i<n; ++i){
            int req = target - nums[i];

            if(mp.containsKey(req) && mp.get(req) != i){
                if(arr[i] == true)
                    continue;
                if( mp.get(req) > x[1] && (x[0] != -1))
                    continue;
                // System.out.println("arr[" + i + "]=" +nums[i] + " req=" + req);

                x[0] = i;
                x[1] = mp.get(req);

                arr[i] = true;
                arr[mp.get(req)] = true;
            
                // Arrays.sort(x);
                // System.out.println(x[0] + " " + x[1]);
            }
        }
        return x;
    }
    public static void main (String args[]) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        int tar = sc.nextInt();

        int[] x = twoSum(arr, tar);
        if(x[0] == -1){
            System.out.print("-1");
            return;
        }
        System.out.println(x[0] + " " + x[1]);
       
    }
}