import java.util.*;

class Solution {
    private List<String> wordDict;
    List<String> res;

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        res = new ArrayList<>();
        
        findWord(s, 0, new StringBuilder());

        return res;
    }

    private boolean findWord(String s, int i, StringBuilder sb) {
        if (i == s.length()) {
            res.add(sb.substring(0, sb.length() - 1));
            return true;
        }

        for (String k: wordDict) {
            if (s.startsWith(k, i)) {
                sb.append(k + " ");
                findWord(s, i + k.length(), sb);
                sb.delete(sb.length() - k.length() - 1, sb.length());
            }
        }
        
        return false;
    }

    public static void main(String...args){
        Solution o = new Solution();

        String s = "cat";
        String[] arr = {"cat"};
        o.wordBreak(s, Arrays.asList(arr));
        System.out.println("\n" + o.res);

    }
}