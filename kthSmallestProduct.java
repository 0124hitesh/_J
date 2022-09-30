class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long l = (long)-1e10, r = (long)1e10;
		long mid;

		while(l < r){
			mid = l + r + 1 >> 1;
			if(countElements(nums1, nums2, mid) < k) l = mid; 
			else r = mid - 1;
		}

		return r;
    }
    
    private long countElements(int[] a, int[] b, long me){
		long count = 0;
		for(int x : a){
			if(x > -1){
                int l = 0, r = b.length;
				while(l < r){
					int mid = r + l >>> 1;
					if((long)x * b[mid] < me) l = mid + 1;
					else r = mid;
				}
				count += l;
			}
			else{
                int l = 0, r = b.length;
				while(l < r){
					int mid = r + l >>> 1;
					if((long)x * b[mid] >= me) l = mid + 1;
					else r = mid;
				}
				count += b.length - l;
			}
		}
		return count;
	}
}