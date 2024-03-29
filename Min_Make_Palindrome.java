class Solution {

    int minCharactersToBeInserted(String A) {
        StringBuilder rev = new StringBuilder(A);
        rev.reverse();
        int lcs = getLengthOfLCS(A, rev.toString());

        return A.length() - lcs;
    }

    // Longest Common Subsequence
    int getLengthOfLCS(String s1, String s2) {
        int a = s1.length(), b = s2.length();
        int[][] dp = new int[a + 1][b + 1];

        for (int i = 1; i <= a; ++i) {
            for (int j = 1; j <= b; ++j) {
                if (s1.charAt(a - i) == s2.charAt(b - j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[a][b];
    }

    // Solution - 2
    // int minCharactersToBeInserted(String s) {
    //     StringBuilder rev = new StringBuilder();
    //     rev.append(s);
    //     rev.reverse();
    //     s += '#';
    //     s += rev;

    //     int n = s.length(), palindromeLength = 0;
    //     int[] lps = new int[n];
    //     lps[0] = 0;
    //     int i = 1;

    //     while (i < n) {
    //         if (s.charAt(i) == s.charAt(palindromeLength)) {
    //             palindromeLength++;
    //             lps[i++] = palindromeLength;
    //         } else {
    //             if (palindromeLength == 0)
    //                 lps[i++] = 0;
    //             else
    //                 palindromeLength = lps[palindromeLength - 1];
    //         }
    //     }

    //     int ans = n / 2 - lps[n - 1];
    //     return ans;
    }
}