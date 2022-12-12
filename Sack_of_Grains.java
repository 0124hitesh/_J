// You are given a sack which can hold grain of weight w. 
// You have grains of n different varieties, each weighing weighti kg and 
// having a value of ₹ moneyi. 
// What is the maximum worth of grain the sack can be filled with?

import java.util.*;

class AA {
	class Grain {
		public int weight, value;
		public Grain(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	double maxSackValue(Grain[] grains, int w) {
		
		Arrays.sort(grains, (a, b) -> {
			double aPrice = (double)a.weight/a.value;
			double bPrice = (double)b.weight/b.value;
			
			if(aPrice > bPrice) return 1;
			
			return -1;
		});
			
		int i = 0;
		double res = 0;
		
		while(w > 0 && i < grains.length){
			int wei = Math.min(w, grains[i].weight);
			w -= wei;
			res += (double)wei * ((double)grains[i].value/grains[i].weight);
			++i;
		}
		
		return res;
	}
}