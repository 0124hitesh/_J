import java.util.*;

class Main{
    private static boolean isAllocate(int mid, int nst, int[] arr){

        int stu = 1;
        int bookNo = 0;
        int pageRead = 0;

        while(bookNo < arr.length){

            if(pageRead + arr[bookNo] <= mid){
                pageRead += arr[bookNo];
                ++bookNo;
            }
            else{
                ++stu;
                pageRead = 0;
            }

            if(stu > nst)
                return false;
        }

        return true;
	}
	public static void main(String[] args) {
			
        int[] arr = {10, 20, 30, 40};
        int nb = 4;
        int nst = 2;

        int sum = 0;
        for(int x : arr)
            sum+=x;

        int l = 0;
        int r = sum;

        while(r > l+1){
            int mid = (l + r)/2;

            if(isAllocate(mid, nst, arr))
                r = mid;
            else
                l = mid;
        }
        System.out.println(r);
    }
}