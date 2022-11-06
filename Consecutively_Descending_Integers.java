class A {
	public boolean isCon(int in ,long pre, String s){
        if(in == s.length()){
            return true;
        }
        long num = 0;
        for(int i = in; i < s.length(); ++i){
            num = num*10 + s.charAt(i) - '0';

            if(pre == -1){
                if(i == s.length() - 1) return false;
            }
            else if(num > pre) return false;
           
            if(pre == -1 || pre - num == 1){
                if(isCon(i+1, num, s)){
                    return true; 
                }
            }
        }
        return false;
    }
    public boolean splitString(String s) {
        return isCon(0, -1, s);
    }
	public static void main(String... args) {
		// Scanner sc = new Scanner(System.in);
		// String s = sc.nextLine();

		String s = "0896942443130";
		System.out.println(new A().splitString(s));
	}
}