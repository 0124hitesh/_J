import java.util.*;
public class Main {
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        Arrays.sort(nums);
        
        int count = 1;
        for(int i=1; i<n; ++i){
            if(nums[i] == nums[i-1])
                ++count;
            else
                count = 1;
            
            if(count > n/2)
                return nums[i];
        }
        
        return 0;
    }

    public static void main (String args[]) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; ++i)
            arr[i] = sc.nextInt();

        System.out.println(majorityElement(arr));
    }
}