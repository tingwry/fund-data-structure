
public class ZoomaList extends CDLinkedList {
	int score = 0;

	public ZoomaList() {
		super();
	}

	public ZoomaList(CDLinkedList l) {
		header = l.header;
		size = l.size;
	}

	public void insert(int value, Iterator p) throws Exception {
		//fill code 	
		super.insert(value, p);
		
		DListIterator v = (DListIterator) p;
		DListIterator current = new DListIterator(v.currentNode.nextNode);
		DListIterator l = new DListIterator(current.currentNode.previousNode);
		DListIterator r = new DListIterator(current.currentNode.nextNode);
		
		int num = 1;

		while (l.currentNode.data == current.currentNode.data) {
			l.previous();
			num ++;
		}
		while (r.currentNode.data == current.currentNode.data) {
			r.next();
			num ++;
		}
		
		if (num >= 3 ) {
			removeBetween(l, r, num);
			score += num;
		}
		
		// Front/Back gone
		while (l.currentNode.data == r.currentNode.data) {
			if (l.currentNode == header || r.currentNode == header) {
				return;
			}
			num = 2;
			while (l.currentNode.previousNode.data == l.currentNode.data) {
				l.previous();
				num ++;
			}
			l.previous();
			
			while (r.currentNode.nextNode.data == r.currentNode.data) {
				r.next();
				num ++;
			}
			r.next();
			
			if (num >= 3 ) {
				removeBetween(l, r, num);
				score += num;
			}
		}
		
	}

	
	public void removeBetween(DListIterator left, DListIterator right, int inc) throws Exception{
		//fill code
		if (left.currentNode == right.currentNode) {
			return;
		}
		this.size -= inc;
		DListIterator l = (DListIterator) left;
		DListIterator r = (DListIterator) right;
		l.currentNode.nextNode = r.currentNode;
		r.currentNode.previousNode = l.currentNode;
		
	}

}
