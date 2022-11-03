class Solution {
    public String minWindow(String ss, String tt) {

        int[] res = { -1, -1 };
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        int temp = 0;
        for (char c : t) {
            if (++tArr[c] == 1)
                ++temp;
        }

        int in = 0, minL = s.length, count = 0, la;
        for (la = 0; la < s.length; ++la) {
            char c = s[la];
            if (tArr[c] > 0) {
                if (++sArr[c] == tArr[c])
                    ++count;
            }
            if (count == temp) {
                while (count == temp) {
                    char f = s[in++];
                    if (tArr[f] > 0) {
                        if (--sArr[f] < tArr[f]) {
                            --count;
                        }
                    }
                }
                --in;
                if (la - in < minL) {
                    minL = la - in + 1;
                    res[0] = in;
                    res[1] = la;
                }
                ++in;
            }
        }
        return res[0] == -1 ? "" : ss.substring(res[0], res[1] + 1);
    }
}