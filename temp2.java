class Solution {
	public boolean isMatch(String str, String pat) {
	   return check(0, 0, str, pat);
   }
   
   private boolean check(int i, int j, String s, String p){
	   if(j == p.length()) {
		   return i == s.length();
	   }
	   if(i > s.length() || j > p.length()) return false;

	   char cp = p.charAt(j);
	   boolean res = false;

	   if(j < p.length() - 1 && p.charAt(j + 1) == '*'){
		   if(i == s.length() - 1) return true; 
		   int t = i;
		   boolean b = false;
		   res = check(i, j + 2, s, p);
		   if(res) return true;
		   while(t < s.length() && (s.charAt(t++) == cp || cp == '.')){
			   b = check(t, j, s, p);
			   if(b) {
				   return true;
			   }
			   res = check(t, j + 2, s, p);
			   if(res) return true;
		   }
		   res = check(t, j + 2, s, p);
	   }
	   else if(cp == '.' || cp == s.charAt(i)){
		   res = check(i + 1, j + 1, s, p);
	   }

	   return res;
   }
}