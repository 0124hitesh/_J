import java.util.*;

class A{
   
    // You are given a string s and a word list wordDict which is a list of unique strings.
    //  You have to determine if s can be broken down into a sequence of words 
    //  where each word is an element in wordDict

    // #Method - 1
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     boolean[] dp = new boolean[s.length() + 1];
    //     Set<String> set = new HashSet<>();
    //     set.addAll(wordDict);

    //     dp[0] = true;
    //     for (int i = 1; i <= s.length(); i++) {
    //         for (int j = i - 1; j >= 0; j--) {
    //             dp[i] = dp[j] && set.contains(s.substring(j, i));
    //             if(dp[i]) break;
    //         }
    //     }
    //     return dp[s.length()];
    // }

    // #Method - 2

    private List<String> wordDict;
    boolean[] visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        visited = new boolean[s.length() + 1];
        return findWord(s, 0);
    }

    private boolean findWord(String s, int i) {
        if (i == s.length()) return true;

        visited[i] = true;

        for (String k: wordDict) {
            if (s.startsWith(k, i)) {
                if (!visited[i + k.length()] && findWord(s, i + k.length()))
                    return true;
            }
        }
        
        return false;
    }

    public static void main(String...args){
    
       String s = "leetcode";
       String[] arr = {"leet", "code"};
       List<String> l = new ArrayList<>(Arrays.asList(arr));

        new A().wordBreak(s, l);
    //    System.out.println/

    }
}