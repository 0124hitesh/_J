// Given the start and finish time of n meetings and just one room to conduct them, 
// find the maximum number of meetings that can be accommodated in that room.

import java.util.*;

class Solution {
	
    class Meeting{
        int start;
		int end;
		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
    }
    
	int getMaxMeetings(Meeting[] meetings) {
		Arrays.sort(meetings, (a, b) -> a.end - b.end);
		
		int res = 0, meetEnd = 0;
		for(Meeting x: meetings){
			if(x.start >= meetEnd){
				++res;
				meetEnd = x.end;
			}
		}
		
		return res;
	}
}