// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/

import java.util.*;

class Solution {
	int wordLen;
    int wordsLen;
    
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();

		wordLen = words[0].length();
        wordsLen = words.length;
		int totalWordLen = wordLen * words.length;

		Map<String, Integer> m = new HashMap<>();
		for(String word: words)
			m.putIfAbsent(word, m.size());

		int[] count = new int[m.size()];
		for(String word: words)
			count[m.get(word)]++;

		char[] arr = s.toCharArray();
		int[] hasString = new int[arr.length];
		Arrays.fill(hasString, -1);
		for(int i = 0; i <= s.length() - wordLen; ++i){
			String temp = new String(arr, i, wordLen);

			if(m.containsKey(temp))
				hasString[i] = m.get(temp);
		}

		for(int i = 0; i <= arr.length - totalWordLen; ++i){
			boolean ans = isString(i, 0, hasString, count, m);
			if(ans) res.add(i);
		}

		return res;
	}

	boolean isString(int i, int c, int[] hasString, int[] count, Map<String, Integer> m){
		if(c == wordsLen) return true;

		if(hasString[i] == -1 || count[hasString[i]] == 0) return false;

		count[hasString[i]]--;
		boolean b = isString(i + wordLen, c + 1, hasString, count, m);
		count[hasString[i]]++;

		return b;
	}
}

// class Solution {
//     char[] arr;

//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> res = new ArrayList<>();
//         int len = words[0].length();
//         arr = s.toCharArray();

// 		Map<String, Integer> m = new HashMap<>();
//         for(String word : words) 
// 			m.put(word, m.getOrDefault(word, 0) + 1);
        
//         int conLen = s.length() - words.length * len;
//         for(int i = 0; i <= conLen; ++i){
//             boolean ans = concatenateString(i, len, s, m);
//             if(ans) res.add(i);
//         }

// 		return res;
//     }

//     boolean concatenateString(int i, int len, String s, Map<String, Integer> m){
//         if(m.isEmpty()) return true;

//         String str = new String(arr, i, len);
// 		Integer cou = m.get(str);

// 		if(cou == null) return false;

// 		if(cou == 1) m.remove(str);
// 		else m.put(str, cou - 1);

// 		boolean b = concatenateString(i + len, len, s, m);
// 		m.put(str, cou);

// 		return b;
//     }
// }