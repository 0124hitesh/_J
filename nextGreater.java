import java.util.*;

public class Main {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		// int t = scn.nextInt();

		// while (t > 0) {
		// 	int n = scn.nextInt();
		// 	int[] arr = new int[n];

		// 	for (int i = 0; i < arr.length; i++)
		// 		arr[i] = scn.nextInt();

		// 	nextLarger(arr);

		// 	t--;
		// }
        int[] arr = {14, 4, 89, 60};
        nextLarger(arr);
	}

	public static void nextLarger(int[] arr) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        int[] ng = new int[arr.length];

        for(int i=1; i<arr.length; ++i){
            
            while(!st.isEmpty() && arr[st.peek()] < arr[i])
                ng[st.pop()] = arr[i]; 
            st.push(i);
        }
        while(!st.isEmpty())
            ng[st.pop()] = -1;

        for(int i =0 ; i<arr.length; ++i)
            System.out.println(arr[i] + "," + ng[i]);

	}
}
