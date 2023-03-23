import java.util.ArrayList;

public class ArrayListStack implements Stack {
	private ArrayList<Integer> a;
	private int MAX_SIZE = 100000;

	// implement a default constructor and all methods from interface Stack.
	// Additional methods maybe required in order to run tests.
	public ArrayListStack() {
		a = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getA() {
		return a;
	}

	@Override
	public boolean isEmpty() {
		return a.isEmpty();
	}

	@Override
	public boolean isFull() {
		return a.size() == MAX_SIZE;
	}

	@Override
	public void makeEmpty() {
		a = new ArrayList<Integer>();
	}

	@Override
	public int top() throws Exception {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return a.get(a.size() - 1);
	}

	@Override
	public void pop() throws Exception {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		a.remove(a.size() - 1);
	}

	@Override
	public void push(int data) throws Exception {
		a.add(data);
	}

}
