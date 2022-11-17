import java.util.*;

// Kth Largest Element in a Stream
class KthLargest {
    private Queue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        this.k = k;
        for(int i: nums) add(i);
    }
    
    public int add(int val) {
         q.offer(val);
         if(q.size() > k) q.remove();
         return q.peek();
    }
}

// Find Median from Data Stream
class MedianFinder {
    Queue<Integer> s, l;

    public MedianFinder() {
        s = new PriorityQueue<>((a, b) -> b - a);
        l = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        l.add(num);
        s.add(l.poll());
        if(s.size() > l.size())
            l.add(s.poll());
    }
    
    public double findMedian() {
        if(l.size() > s.size()) return l.peek();
        return (s.peek() + l.peek())/2f;
    }
}