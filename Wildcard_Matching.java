class Solution {
    public boolean isMatch(String s, String p) {
        return check(s, p, 0, 0) == 2;
    }

    private int check(String s, String p, int i, int j){
         if(i == s.length()){
            if(j == p.length()) return 2;

            // no need to check further if true
            if(p.charAt(j) != '*') return 1;
        }
        
        if(j == p.length()) return 0;

        if(p.charAt(j) == '*'){
            if(j + 1 < p.length() && p.charAt(j + 1) == '*')    
                return check(s, p, i, j + 1);

            for(int t = i; t <= s.length(); ++t){
                int ans = check(s, p, t, j + 1);
                if(ans == 1 || ans == 2) return ans;
            }
        }
        if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))
            return check(s, p, i + 1, j + 1);

        return 0;
    }
}