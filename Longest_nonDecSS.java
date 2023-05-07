class Solution {
    int[] min;

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        min = new int[n];

        int[] res = new int[n];
        int len = 0, idx, num;

        for(int i = 0; i < n; ++i){
            num = obstacles[i];
            idx = binarySearch(0, len - 1, num);
            // add current obstacle
            min[idx] = num;

            // we add current obstacle and then update length
            if(idx == len) ++len;
            res[i] = idx + 1;
        }

        return res;
    }

    // binary search to find position where we can add current obstacle in the min array
    private int binarySearch(int l, int h, int tar){
        int mid;

        while(l <= h){
            mid = (l + h) >> 1;

            if(min[mid] <= tar) l = mid + 1;
            else h = mid - 1;
        }   

        return l;
    }
}