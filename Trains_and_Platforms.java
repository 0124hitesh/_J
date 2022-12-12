// You are given the arrival and departure times for n trains at a railway station. 
// Find the minimum number of platforms the railway station needs so that 
// none of the trains have to wait.

// The time is given in minutes from midnight. All trains have departures on the same day.

// Exam - 
// Trains (arrival, departure): [(120, 130), (130, 150), (125, 145), (150, 180)]
// Output: 3
// Explanation: At 2:10 AM (130th minute), there are 3 trains at the station.

import java.util.*;

class Solution {
	class Train {
		public int arrival, departure;
		public Train(int arrival, int departure) {
			this.arrival = arrival;
			this.departure = departure;
		}
	}
	
	int minPlatforms(Train[] trains) {
		
		Arrays.sort(trains, (a, b) -> a.arrival - b.arrival);
		PriorityQueue<Integer> p = new PriorityQueue<>();
		
		int res = 0;
		for(Train x: trains){
			int arr = x.arrival;
			while(!p.isEmpty() && p.peek() < arr) p.poll();
			
			p.add(x.departure);
			if(p.size() > res) res = p.size();
		}
		
		return res;
	}
}