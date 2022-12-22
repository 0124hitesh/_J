class Solution {

	// Step - 1 Direct Approach
	// int[] zFunction(char[] s, int n) {
	// 	int[] z = new int[n];

	// 	for(int i = 1; i < n; ++i){
	// 		int count = 0;

	// 		int j = 0;
	// 		int k = i;

	// 		while(k < n && s[j] == s[k]){
	// 			++j;
	// 			++k;
	// 			++count;
	// 		}

	// 		z[i] = count;
	// 	}

	// 	return z;
	// }

	// Step - 2
	// int[] zFunction(char[] s, int n) {
	// 	int[] z = new int[n];
	// 	int left = 0, right = 0;

	// 	for(int i = 1; i < n; ++i){
	// 		if(i <= right){
	// 			z[i] = Math.min(n - right + 1, z[i - left]);
	// 			continue;
	// 		}

	// 		int count = 0;

	// 		int j = 0;
	// 		int k = i;

	// 		while(k < n && s[j++] == s[k++]){
	// 			++count;
	// 		}

	// 		left = i;
	// 		right = k;

	// 		z[i] = count;
	// 	}

	// 	return z;
	// }

	int[] zFunction(char[] s, int n) {
		int[] z = new int[n];
		int left = 0, right = 0;

		for(int i = 1; i < n; ++i){
			if(i <= right){
				z[i] = Math.min(n - right + 1, z[i - left]);
				continue;
			}

			// for now z[i] = 0
			while(i + z[i] < n && s[z[i]] == s[z[i] + i]){
				z[i]++;
			}

			if(i + z[i] - 1 > right){
				left = i;
				right = i + z[i] - 1;
			}
		}

		return z;
	}

	int findStartIndexOfSubstring(String s1, String s2) {
		String mixed = s2 + "$" + s1;
		char[] aux = mixed.toCharArray();
		
		int[] getZ = zFunction(aux, mixed.length());

		for (int i = 0; i < mixed.length(); i++) {
			if (getZ[i] >= s2.length()) {
				return (i - s2.length() - 1);
			}
		}
		return -1;
	}

	public static void main(String...args){
		String s1 = "helloworld";
		String s2 = "low";

		System.out.println(new Solution().findStartIndexOfSubstring(s1, s2));
	}
}