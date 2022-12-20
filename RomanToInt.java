import java.util.*;

class Solution {
    int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        char[] c = s.toCharArray();
        int[] n = new int[s.length()];

        int res = 0;
        for (int i = 0; i < n.length; ++i) 
            n[i] = m.get(c[i]);

            for(int i = 0; i < n.length - 1; ++i){
                res = n[i] >= n[i + 1] ? res + n[i] : res - n[i];
           }
           
           res += n[n.length - 1];
           return res;
    }

    String integerToRoman(int num) {
        String[] romanSymbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder roman = new StringBuilder();
        for (int i = 0; num != 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanSymbols[i]);
            }
        }
        return roman.toString();
    }

    public static void main(String...args){
        String s = "MCMXCIV";

        new Solution().romanToInt(s);
    }
}