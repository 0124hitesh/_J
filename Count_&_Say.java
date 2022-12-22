class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        char[] prevString = countAndSay(n - 1).toCharArray();

        StringBuilder res = new StringBuilder();
        int count = 0;
        char prev = '0';

        for (int i = 0; i < prevString.length; ++i) {
            if (prevString[i] == prev) {
                ++count;
            } else {
                if (prev != '0') {
                    res.append(count);
                    res.append(prev);
                }
                prev = prevString[i];
                count = 1;
            }
        }
        res.append(count);
        res.append(prev);

        return res.toString();
    }
}