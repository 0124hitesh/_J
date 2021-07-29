import java.util.*;
public class Main {
	public static List<List<String>> groupAnagrams(String[] strs) { 
        Map<String, List<String>> hm = new HashMap<>();
        
        for(int i=0; i<strs.length; ++i){
            
            char[] c= strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            
            if(hm.containsKey(s)){
                List<String> l = hm.get(s);
                l.add(strs[i]);
                hm.put(s, l);
            }
            else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                hm.put(s, l);
            }
        }
        
        List<List<String>> l = new ArrayList<>();
        for(List<String> x: hm.values())
            l.add(x);
        
        return l;
    }
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		String[] strs = new String[n];
		for(int i=0; i<n; ++i)
			strs[i] = sc.nextLine();
		
		List<List<String>> l = groupAnagrams(strs);

		for(List<String> ls : l){
			for(String s : ls)
				System.out.print(s + " ");
			System.out.println();
		}
    }
}