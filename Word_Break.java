import java.util.*;

class A{
   
    // You are given a string s and a word list wordDict which is a list of unique strings.
    //  You have to determine if s can be broken down into a sequence of words 
    //  where each word is an element in wordDict
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if(dp[i]) break;
            }
        }
        return dp[s.length()];
    }

    public static void main(String...args){
    
       String s = "leetcode";
       String[] arr = {"leet", "code"};
       List<String> l = new ArrayList<>(Arrays.asList(arr));

        new A().wordBreak(s, l);
    //    System.out.println/

    }
}