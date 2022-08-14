import java.util.*;

public class minSwapArray {

    public void printList(List<HM> l){
        for(HM x : l)
            System.out.println(x.a + " " + x.b);
    }

    public int minSwap(int[] arr) {
        ArrayList<HM> pairList = new ArrayList<>();
        for (int i = 0; i < arr.length; ++i)
            pairList.add(new HM(arr[i], i));
        
        pairList.sort(new Comparator<HM>() {
            public int compare(HM ob1, HM ob2){
                if(ob1.a < ob2.a)
                    return -1;

                return 0;
            }
        });

        // printList(pairList);
        int res = 0;
        boolean[] b = new boolean[arr.length];
        for(int i = 0; i < arr.length; ++i){
            if(b[i] || pairList.get(i).b == i)
                continue;

            int j = i;
            int swap = 0;
            while(!b[j]){
                ++swap;
                b[j] = true;
                j = pairList.get(i).b;
            }
            if(swap > 0)
                res += swap - 1;
        }

        return res;
    }
    

    public static void main(String... args) {
        int[] arr = { 8,4,1,2 };
        minSwapArray ob = new minSwapArray();
        System.out.println(ob.minSwap(arr));
    }
}

class HM{
    int a, b;

    HM(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
