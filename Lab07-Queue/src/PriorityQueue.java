
public class PriorityQueue {
	MyQueue q;

	public PriorityQueue(MyQueue q) {
		super();
		this.q = q;
	}

	// implement this.
	public void push(int x) throws Exception {
		int size = q.size();
		boolean inserted = false;
		
		// find the correct position to insert
		for (int i = 0; i < size ; i++) {
			int v = q.removeFirst();
			if (!inserted && v > x) {
				q.insertLast(x);
				inserted = true;
			}
			q.insertLast(v);
		}
		// if x is the largest value
		if (!inserted) {
			q.insertLast(x);
		}
	}

	// implement this.
	public void pop() throws EmptyQueueException {
		if (q.isEmpty()) {
			throw new EmptyQueueException();
		}
		q.removeFirst();
	}

	// implement this
	public int top() throws EmptyQueueException {
		if (q.isEmpty()) {
			throw new EmptyQueueException();
		}
		return q.front();
	}

}
