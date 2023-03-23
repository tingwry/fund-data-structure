class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}
//

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}
	
	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// Returns the number of data stored in this list.
	// To be completed by students.
	public int size() throws Exception{
		Iterator p = new MyListIterator(header);
		int i = 0;
		while(p.hasNext()) {
			i++;
			p.next();
		}
		return i;
		}
	
	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception{
		MyListIterator p = new MyListIterator(header);
		while(p.hasNext()) {
			p.next();
			String data = p.currentNode.data.toString();
			System.out.println(data);
		}
	}

	//Return iterator pointing to value that stores a given name, or null otherwise.
	//To be completed by students.
	public Iterator findPosition(String name) throws Exception{
		MyListIterator p = new MyListIterator(header);
		while(p.hasNext()) {
			Contact c = (Contact) p.next();
		if (c.name.equals(name)) {
			return p;
		}}

		return null;
	}
	
	//add a new contact to the list the contact must be added in such a way that each contact is sorted by name, in alphabetical order.	
	public void add(Object c) throws Exception{
		Contact contact = (Contact) c;
		ListNode n = header;
		while (n.nextNode != null && ((Contact) n.nextNode.data).name.compareTo(contact.name) < 0) {
			n = n.nextNode;
		}
		n.nextNode = new ListNode(c, n.nextNode);
	}
	
	//Remove the contact pointed by the iterator, i, and then returns an iterator pointing to the next contact. 
	//If the removed contact is the last one, return the iterator pointing to the first contact 
	//   (if there is no first contact, make the iterator point to header). 
	//If i is marking an illegal position that cannot be removed, just return null. 
	//To be completed by students.
	public Iterator removeAt(Iterator i) throws Exception{
		MyListIterator p = (MyListIterator) i;
		ListNode n = header;

		// Find the node to be removed
		while (n.nextNode != null && n.nextNode != p.currentNode) {
			n = n.nextNode;
		}

		if (n.nextNode == null) {
			return null;
		}

		n.nextNode = n.nextNode.nextNode;

		if (n.nextNode != null) {
			return new MyListIterator(n.nextNode);
		} else if (header.nextNode != null) {
			return new MyListIterator(header.nextNode);
		} else {
			return new MyListIterator(header);
		}
		}
	

}