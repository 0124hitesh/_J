class Solution {
	int in, maxLen;

	String lps(String s) {
        int len = s.length();
        if(len < 2) return s;

		in = maxLen = 0;

        for(int i=0; i<len - 1; ++i){
            stringLen(s, i, i);
            stringLen(s, i, i+1);
        }

        return s.substring(in, in + maxLen);
	}
	
	public void stringLen(String s, int i, int j){
        while( i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j) ){
            --i;
            ++j;
        }
        if(maxLen < j - i -1){
            in = i + 1;
            maxLen = j - i - 1;
        }
    }
}