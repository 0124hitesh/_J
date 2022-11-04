import java.util.*;
class Solution {
	List<String> res;
    char[] arr; 

	// using StringBuilder
	public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        arr = s.toCharArray();
        addIP(0, 0, new StringBuilder(), new StringBuilder());
        return res;
    }

    private void addIP(int in, int cou, StringBuilder ns, StringBuilder s){
		if(cou == 4 || in ==arr.length) {
			if(cou == 4 && in ==arr.length) res.add(s.substring(1));
			return;
		}
        if(ns.toString().equals("0")) return;
		StringBuilder n = new StringBuilder(ns);
		n.append(arr[in]);
        addIP(in + 1, cou, n, s);
		
		if(ns.length() < 3){
			ns.append(arr[in]) ;
			int i = Integer.valueOf(ns.toString());
            if( i < 256){
				StringBuilder nn = new StringBuilder(s);
				nn.append("." + ns);
                addIP(in + 1, cou + 1, new StringBuilder(), nn);
            }
        }
    } 

	// using String
    // public List<String> restoreIpAddresses(String s) {
    //     res = new ArrayList<>();
    //     arr = s.toCharArray();
    //     addIP(0, 0, "", "");
    //     return res;
    // }

    // private void addIP(int in, int cou, String ns, String s){
	// 	if(cou == 4 || in ==arr.length) {
	// 		if(cou == 4 && in ==arr.length) res.add(s.substring(1));
	// 		return;
	// 	}
    //     if(ns.equals("0")) return;
    //     addIP(in + 1, cou, ns + arr[in], s);
		
	// 	if(ns.length() < 3){
	// 		ns += arr[in];
	// 		int i = Integer.valueOf(ns);
    //         if( i < 256){
    //             addIP(in + 1, cou + 1, "", s + '.' + ns);
    //         }
    //     }
    // }

	public static void main(String...args){
		Scanner sc = new Scanner(System.in);
		// String s = sc.nextLine();

		Solution o = new Solution();
		String s = "25525511135";
		o.restoreIpAddresses(s);

		for(String ss: o.res)
			System.out.println(ss);
	}
}