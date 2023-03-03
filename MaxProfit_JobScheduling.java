class Solution {

    private class Job implements Comparable<Job>{
        int startTime, endTime, profit;

        Job(int s, int e, int p){
            startTime = s;
            endTime = e;
            profit = p;
        }

        public int compareTo(Job j){
            return this.endTime - j.endTime; 
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = endTime.length;

        Job[] jobs = new Job[len];
        for(int i = 0; i < len; ++i){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs);
		// Arrays.sort(jobs, (a, b) -> a.endTime - b.endTime);

        int[] dp = new int[len];
        dp[0] = jobs[0].profit;

        for(int i = 1; i < len; ++i){
            dp[i] = Math.max(dp[i - 1], jobs[i].profit);
            for(int j = i - 1; j > -1; --j){
                if(jobs[j].endTime <= jobs[i].startTime){
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }

		return dp[len - 1];
    }
}