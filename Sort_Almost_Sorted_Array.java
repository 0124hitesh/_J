import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Iterator;

// Given an array A of size n,which is almost sorted.
// Each element is misplaced by no more than k positions from the correct sorted order.
// You need to find an efficient way to properly sort the array.

class Solution {
    Queue<Integer> q;

    int[] sortAlmostSorted(int[] arr, int k) {
        q = new PriorityQueue<>();

        int min = Math.min(arr.length, k + 1);
        for (int i = 0; i < min; ++i) {
            q.add(arr[i]);
        }

        int ind = 0;
        for (int i = k + 1; i < arr.length; ++i) {
            arr[ind++] = q.poll();
            q.add(arr[i]);
        }

        Iterator it = q.iterator();
        while (it.hasNext())
            arr[ind++] = q.poll();

        return arr;
    }

    public static void main(String...args){
        int[] arr = {2, 4, 1, 5, 3, 7, 8, 6, 10, 9};
        new Solution().sortAlmostSorted(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
