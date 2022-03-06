import java.util.Stack;

class diskSpaceAnalysis {
    
    public static int maxChunk(int[] arr, int x){
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i=1; i<x; ++i){
            if(arr[s.peek()] > arr[i]){
                s.pop();
                s.push(i);
            }
        }

        int n = 1;
        for(int i=x; i<arr.length; ++i){
            int pk = s.peek();
            if(pk >= n){
                s.push(arr[i] < arr[pk] ? i : pk);
            }
            else{
                s.push(i);

                int j = n;

                int count = x;
                while(count-- > 0){
                    if(arr[j] < arr[s.peek()]){
                        s.pop();
                        s.push(i); 
                    }
                    ++j;
                }
            }
            ++n;
        }

        while(!s.isEmpty()){
            System.out.print(arr[s.pop()] + " ");
        }
        
        return 0;
    }

    public static void main(String[] args){

        int[] arr = {2,8,4,3,7,5};
        System.out.println(maxChunk(arr, 3));
    }
}
