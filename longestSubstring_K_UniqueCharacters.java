// Given a string str and a number k, find the length of the longest substring in str 
// with exactly k unique characters.

// str: "aabcdaddaf"
// k: 3
// Explanation:
// substrings with k unique characters: ["aabc", "abc", "bcd", "cda", "cdad", "cdadd", "cdadda", "daddaf", "addaf", "ddaf", "daf"]
// longest substrings: ["cdadda", "daddaf"]
// Result: 6

import java.util.*;
class A {
    int longestSubstringWithKUniqueCharacters(String s, int k) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int res = -1, len = 0;
        int pre = 0;
        for (int i = 0; i < arr.length; ++i) {
            char c = arr[i];

            if (m.size() == k) {
                if (m.containsKey(c)) {
                    m.put(c, m.get(c) + 1);
                    ++len;
                } 
                else {
                    while (m.size() != k - 1) {
                        char preC = arr[pre];
                        int temp = m.get(preC);

                        if (temp == 1) m.remove(preC);
                        else m.put(preC, temp - 1);
                        --len;

                        ++pre;
                    }

                    m.put(c, 1);
                    ++len;

                    if (len > res) res = len;
                }
            } 
            else {
                int temp = m.getOrDefault(c, 0);
                m.put(c, temp + 1);
                ++len;
            }

        }

        return res;
    }

    public static void main(String... args) {
        String s = "aabcdaddaf";
        int k = 3;

        System.out.println(new A().longestSubstringWithKUniqueCharacters(s, k));

    }
}