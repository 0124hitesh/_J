// The reviews need to be sorted by how good they are, the best reviews go on top. 
// The goodness a review is determined by the number of times "good words" appear in them.

// Reviews: ["good restaurant", "tasty food nice ambience", "nice place"]
// Good Words: ["good", "lovely", "nice", "tasty"]
// Output: ["tasty food nice ambience", "good restaurant", "nice place"]

import java.util.*;

class Solution {
	Set<String> gw;
	
	String[] orderReviews(String[] reviews, String[] goodWords) {
	    gw = new HashSet<>();
		for(String s: goodWords){
			gw.add(s);
		}
		
		int[][] count = new int[reviews.length][2];
		for(int i = 0; i < reviews.length; ++i){
			String[] arr = reviews[i].split(" ");
			count[i][0] = i;
			for(String x: arr){
				 if(gw.contains(x)) ++count[i][1];
			}
		}

		Arrays.sort(count, (a, b) -> {
			return b[1] - a[1];
		});

		String[] res = new String[reviews.length];
		for(int i = 0; i < count.length; ++i){
			res[i] = reviews[count[i][0]];
		}

		return res;
	}
}