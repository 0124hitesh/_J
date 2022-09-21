// Find K Pairs with Smallest Sums

import java.util.*;

class A {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return (a[0] + a[1] - b[0] - b[1]);
			}
		});

		List<List<Integer>> res = new ArrayList<>();
		if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;

		for(int i = 0; i < nums1.length && i < k; ++i)
			q.add(new int[]{nums1[i], nums2[0], 0});
		
		while(k-- > 0 && !q.isEmpty()){
			int[] x = q.poll();
			res.add(new ArrayList<>(Arrays.asList(x[0], x[1])));
			if(x[2] < nums2.length - 1)
				q.add(new int[]{x[0], nums2[x[2] + 1], x[2] + 1});
		}

		return res;
	}

	public static void main(String... args) {

		A ob = new A();
		int[] a = { 1, 7, 11 };
		int[] b = { 2, 4, 6 };

		List<List<Integer>> l = ob.kSmallestPairs(a, b, 4);
		for (List<Integer> x : l)
			System.out.println(x.get(0) + " " + x.get(1));
	}
}