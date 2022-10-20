import java.util.*;

class A {

    int longestSubarrayWithZeroSum(int[] A) {
        Map<Integer, Integer> hm = new HashMap<>();

        int sum = 0;
        int max_len = 0;
        hm.put(0, -1);

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            Integer prev_i = hm.get(sum);

            if (prev_i != null)
                max_len = Math.max(max_len, i - prev_i);
            else
                hm.put(sum, i);
        }

        return max_len;
    }

    public static void main(String arg[]) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

        System.out.println(new A().longestSubarrayWithZeroSum(arr));
    }
}