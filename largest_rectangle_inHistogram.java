import java.util.*;
class Solution {
    public int largestRectangleArea(int[] arr) {
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < arr.length; ++i){
            while(!s.isEmpty() && arr[i] < arr[s.peek()]){
                int top = s.pop(), width;
                if(!s.isEmpty()){
                    width = i - s.peek() - 1;
                }
                else{
                    width = i;
                }
                int area = arr[top]*width;
                if(area > maxArea) maxArea = area;
            } 
            s.push(i);
        }

        int i = arr.length;
        while(!s.isEmpty()){
                int top = s.pop(), width;
                if(!s.isEmpty()){
                    width = i - s.peek() - 1;
                }
                else{
                    width = i;
                }
                int area = arr[top]*width;
                if(area > maxArea) maxArea = area;
            } 
        

        return maxArea;
    }

    public static void main(String... args) {

        int[] arr = {2,1,5,6,2,3};
        
        System.out.println(new Solution().largestRectangleArea(arr));
    }
}