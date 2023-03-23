
public class UseStack {
	
	//implement this method.
	public static Stack sort(Stack s) throws Exception {

		ArrayListStack ans = new ArrayListStack();
		while (!s.isEmpty()) {
			int m = s.top();
			s.pop();
			
			while (!ans.isEmpty() && ans.top() < m) {
				s.push(ans.top());
				ans.pop();
			}
			ans.push(m);
			}
		return ans;
	}

}

