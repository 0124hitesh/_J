import java.util.*;

class A {
    int[] distintNumbersInWindow(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < k; ++i) {
            int temp = m.getOrDefault(arr[i], -1);
            if(temp == -1) m.put(arr[i], 1);
            else
                m.put(arr[i], temp + 1);
            
        }

        int in = -1;
        res[++in] = m.size();

        for (int i = k; i < arr.length; ++i) {
            int preK = m.getOrDefault(arr[i - k], -1);
            if(preK == 1) m.remove(arr[i - k]);
            else if(preK > 1) m.put(arr[i - k], preK - 1);

            int cur = m.getOrDefault(arr[i], -1);
            if(cur == -1) m.put(arr[i], 1);
            else m.put(arr[i], cur + 1);

            res[++in] = m.size();
        }

        return res;
    }

    public static void main(String... args) {
        int[] arr = { 1, 1, 2, 1, 4, 6, 5 };
        int[] res = new A().distintNumbersInWindow(arr, 3);

        System.out.print(Arrays.toString(res));
    }
}