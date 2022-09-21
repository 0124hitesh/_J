import java.util.*;

class A {
	public static void main(String... args) {

		// Priority based - higher value, higher priority
		Queue<Integer> q = new PriorityQueue<>();
		q.add(3);
		q.add(2);
		q.add(1);
		q.add(4);

		// System.out.println(q);
		// System.out.println(q.poll());
		// System.out.println(q.poll());
		// System.out.println(q.poll());
		// System.out.println(q.poll());

		// FIFO
		Queue<Integer> z = new LinkedList<>();
		z.add(5);
		z.add(1);
		z.add(2);
		z.add(3);
		z.add(4);
		System.out.println(z.poll());
		System.out.println(z.poll());
		System.out.println(z);
	}
}