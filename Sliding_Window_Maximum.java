import java.util.*;

class A {

    // using Priority Queue
    // gives TLE
    // public int[] maxSlidingWindow2(int[] nums, int k) {
    //     int len = nums.length;
    //     if (k < len)
    //         len = nums.length - k + 1;

    //     int[] res = new int[len];

    //     Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
    //     for (int i = 0; i < k; ++i) {
    //         q.add(nums[i]);
    //     }

    //     int p = 0;
    //     res[p] = q.peek();

    //     for (int i = k; i < nums.length; ++i) {
    //         q.remove(nums[i - k]);
    //         q.add(nums[i]);
    //         res[++p] = q.peek();
    //     }

    //     return res;
    // }

    
    // Using Deque
    // Deque - can remove/add element at first and last both.
    public int[] maxSlidingWindow(int[] A, int k) {

        int[] res = new int[A.length - k + 1];
        Deque<Integer> deq = new ArrayDeque<>(k);
        for (int i = 0; i < k; i++) {
            if (!deq.isEmpty() && i - deq.getFirst() == k) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && A[deq.getLast()] < A[i]) {
                deq.removeLast();
            }
            deq.addLast(i);
        }

        int idx = 0;
        res[idx] = A[deq.getFirst()];

        for (int i = k; i < A.length; i++) {
            if (!deq.isEmpty() && i - deq.getFirst() == k)
                deq.removeFirst();
            while (!deq.isEmpty() && A[deq.getLast()] < A[i])
                deq.removeLast();

            deq.addLast(i);
            res[++idx] = A[deq.getFirst()];
        }
        return res;

    }

    public static void main(String... args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 2;
        int[] res = new A().maxSlidingWindow(arr, k);

        System.out.print(Arrays.toString(res));
    }
}