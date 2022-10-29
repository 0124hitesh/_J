import java.util.*;

class A{
    int numSubarrayWithXOR(int[] A, int tar) {
	    Map<Integer, Integer> m = new HashMap<>();
        int res = 0, xor = 0;

        for(int i = 0; i < A.length; ++i){
            
			xor ^= A[i];
			if(xor == tar) ++res;
			
            int temp = tar ^ xor;
            if(m.containsKey(temp)) res += m.get(temp);

            if(m.containsKey(xor)) m.put(xor, m.get(xor) + 1);
            else m.put(xor, 1);
        }

        return res;
	}
    public static void main(String...args){
        int[] arr = {1,4,1,4};

        System.out.println(new A().numSubarrayWithXOR(arr, 5));

    }
}