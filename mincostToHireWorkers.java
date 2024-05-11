import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        // As per question, wage[i] / quality[i] = wage[j] / quality[j]
        // So, wage[i] / quality[i] = totalWage / totalQuality
        // totalWage = (wage[i] / quality[i]) * totalQuality

        double[][] workers = new double[n][2];
        for (int i = 0; i < n; ++i) {
            workers[i] = new double[]{1.0 * wage[i] / quality[i], quality[i]};
        }
        Arrays.sort(workers, Comparator.comparingDouble(a -> a[0]));

        // for (double[] worker: workers) {
        //     System.out.println(Arrays.toString(worker));
        // }
        
        // top value will be highest
        PriorityQueue<Double> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> -a));
        double totalQ = 0, res = Double.MAX_VALUE;

        for (double[] worker: workers) {
            totalQ += worker[1];
            minHeap.add(worker[1]);

            // remove worker with highest quality
            if (minHeap.size() > k) totalQ -= minHeap.poll();
            // current worker[0] will always be highest than previous ones, as array is sorted
            // so no worker will be paid under their expectation
            if (minHeap.size() == k) res = Math.min(res, totalQ * worker[0]);
        }

        return res;
    }

    public static void main(String...args) {
        int[] wage = {4,8,2,2,7};
        int[] quality = {3,1,10,10,1};
        int k = 3;

        System.out.println("\n" + new Solution().mincostToHireWorkers(quality, wage, k));
    }
}