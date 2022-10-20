import java.util.*;

class A {
    private int[] nearestLeftSmall(int[] arr) {

        Stack<Integer> s = new Stack<>();
        int[] res = new int[arr.length];
        Arrays.fill(res, 10);

        for(int i = 0; i < arr.length; ++i){

            while(!s.isEmpty() && arr[i] < arr[s.peek()]){
                int top = s.pop();
                if(!s.isEmpty()){
                    res[top] = s.peek();
                }
                else {
                    res[top] = -1;
                }
            }
            s.push(i);
        }
        // For last element
        while(!s.isEmpty()){
            int top = s.pop();
            if(!s.isEmpty()){
                res[top] = s.peek();
            }
            else {
                res[top] = -1;
            }
        }

        return res;
    }

    public static void main(String... args) {

        int[] arr = {2,1,5,5,5,6,2,3};
        int[] res = new A().nearestLeftSmall(arr);

        for(int i = 0; i < arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < arr.length; ++i){
            System.out.print(res[i] + " ");
        }
    }
}