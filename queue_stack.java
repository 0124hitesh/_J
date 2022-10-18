import java.util.*;

// Stack using Queue
class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); ++i)
            q.add(q.remove());
    }
    
    public int pop() {
        return q.remove();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

// Queue using Stack
class MyQueue {

    Stack<Integer> inp;
    Stack<Integer> oup;

    public MyQueue() {
        inp = new Stack<>();
        oup = new Stack<>();
    }
    
    public void push(int x) {
        inp.push(x);
    }
    
    public int pop() {
        peek();
        return oup.pop();
    }
    
    public int peek() {
        if(oup.empty())
            while(!inp.empty())
                oup.push(inp.pop());
        return oup.peek();
    }
    
    public boolean empty() {
        return inp.empty() && oup.empty();
    }
}

// Min_Stack

// Implement the below class
// Assume that pop, top and getMin will only be called on non-empty stack.
class MinStack {
	Stack<Integer> s;
	int min;
	
	public MinStack(){
		s = new Stack<>();
		min = Integer.MAX_VALUE;
	}
    void push(int x) {
		if(x <= min) {
			s.push(min);
			min = x;
		}
		s.push(x);
    }
    void pop() {
	    if(s.pop() == min) min = s.pop();
    }
    int top() {
		return s.peek();   
	}
    int getMin() {
	    return min;
    }
}