// You are given a list of tasks, 
// each having a deadline and associated profit if completed within the deadline. 
// Each task takes 1 unit of time to complete. What is the maximum profit you can make?

// Tasks (deadline, profit): [(4, 20), (2, 10), (2, 40), (1, 30)]
// Output: 90
// Explanation: Order of Tasks: 4, 3, 1

class Solution {
	class Task {
		public int deadline, profit;
		public Task(int deadline, int profit) {
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	int getMaxProfit(Task[] tasks) {
		Arrays.sort(tasks, (a, b) -> a.deadline - b.deadline);
		
		PriorityQueue<Integer> p = new PriorityQueue<>();
		
		for(Task x: tasks){
			if(p.size() == x.deadline){
				if(p.peek() >= x.profit) continue;
				p.poll();
			}
			p.add(x.profit);
		}
		
		int res = 0;
		while(!p.isEmpty()) res += p.poll();
	
		return res;
	}
}