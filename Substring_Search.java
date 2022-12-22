class Solution {
	

    // using Hashing
	int rabinKarp(char[] pattern, char[] text, int m, int n) {
        int CHARSET = 26;
	    int MOD = 29;

		int hash = 1, patternHash = 0, textHash = 0;
		for(int i = 1; i < m; i++) {
			hash *= CHARSET;
			hash %= MOD;
		}

		for(int i = 0; i < m; i++) {
			patternHash = (patternHash * CHARSET + pattern[i]) % MOD;
			textHash = (textHash * CHARSET + text[i]) % MOD;
		}

		for(int i = 0; i <= n - m; i++) {
			if(patternHash == textHash) {
				int index = 0;

				for(int j = 0; j < m; j += 1, index += 1) {
					if(text[i + j] != pattern[j]) {
						break;
					}
				}
				if(index == m) {
					return i;
				}
			}
			if(i + m < n) {
				textHash = ((textHash - text[i]*hash) * CHARSET + text[i + m]) % MOD;
				if(textHash < 0) {
					textHash += MOD;
				}
			}
		}

		return -1;
	}

    int findStartIndexOfSubstring(String s1, String s2) {
        int m = s2.length();
	    int n = s1.length();
	    if(m > n) {
		   return -1;
	    }
	    return rabinKarp(s2.toCharArray(), s1.toCharArray(), m, n);
    }

    // KMP (Knuth-Morris-Pratt) algorithm
    // int findStartIndexOfSubString(String s1, String s2) {
		// if (s1.length() < s2.length()) {
		// 	return - 1;
		// }
		
		// for (int i = 0; i <= s1.length() - s2.length(); i++) {
		// 	int substringFound = 1;
		// 	for (int j = 0; j < s2.length(); j++) {
		// 		if (s1.charAt(i + j) != s2.charAt(j)) {
		// 			substringFound = 0;
		// 			break;
		// 		}
		// 	}
		// 	if(substringFound == 1) {
		// 		return i;
		// 	}
		// }
		// return - 1;
	// }


	// Z Algorithm 

	// How to reach approch
	// (find temp.java file with this commit "Substring_Search")

	// int[] zFunction(char[] s, int n) {
	// 	int[] z = new int[n];
	// 	int left = 0, right = 0;

	// 	for (int i = 1; i < n; i++) {
	// 		if (i <= right) {
	// 			z[i] = Math.min(right - i + 1, z[i - left]);
	// 		}

	// 		while (i + z[i] < n && s[z[i]] == s[z[i] + i]) {
	// 			z[i]++;
	// 		}

	// 		if (i + z[i] - 1 > right) {
	// 			left = i;
	// 			right = i + z[i] - 1;
	// 		}
	// 	}

	// 	return z;
	}

	// int findStartIndexOfSubstring(String s1, String s2) {
	// 	String mixed = s2 + "$" + s1;
	// 	char[] aux = mixed.toCharArray();
		
	// 	int[] getZ = zFunction(aux, mixed.length());

	// 	for (int i = 0; i < mixed.length(); i++) {
	// 		if (getZ[i] == s2.length()) {
	// 			return (i - s2.length() - 1);
	// 		}
	// 	}
	// 	return -1;
	// }

    public static void main(String...args){
        String s1 = "helloworld";
        String s2 = "low";

        System.out.println(new Solution().findStartIndexOfSubstring(s1, s2));
    }
}