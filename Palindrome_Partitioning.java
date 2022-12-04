import java.util.*;

class Solution {
    List<List<String>> res;

    boolean isPal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    void partition(int start, String s, List<String> l){
       if(start == s.length()) {
           res.add(new ArrayList<>(l));
           return;
       }

       for(int i = start; i < s.length(); ++i){
           if(isPal(s, start, i)){
               l.add(s.substring(start, i + 1));
               partition(i + 1, s, l);
               l.remove(l.size() - 1);
           }
       }
    }

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        partition(0, s, new ArrayList<>());

        return res;
    }

    public static void main(String...args){
        String s = "";
        new Solution().partition(s);
    }
}