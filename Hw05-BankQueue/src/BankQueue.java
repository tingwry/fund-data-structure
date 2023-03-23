
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		int queues = counters.length + 1;
		int people = 0;
		
		for (int i = 0; i < counters.length; i++) {
			people += counters[i].size(); 
		}
		// System.out.println("queues: " + queues);
		// System.out.println("people: " + people);
		float neededLength = (float) people/ (float) queues;
		// System.out.println(neededLength);
		if (neededLength % 1 >= 0.5) {
			neededLength = neededLength - (neededLength % 1) + 1;
		} else {
			neededLength = neededLength - (neededLength % 1);
		}
		// System.out.println(neededLength);
		
		for (int i = 0; i < counters.length; i++) {
			DeQ currentQ = counters[i];
			DeQArray temp = new DeQArray();
			if (currentQ.size() > neededLength) {
				for (int j = 0; j < neededLength; j++) {
					// System.out.println("insert" + currentQ.front() + "to temp");
					temp.insertLast(currentQ.removeFirst());
				}
				while (special.size() < neededLength && !currentQ.isEmpty()) {
					// System.out.println("insert " + currentQ.front() + "to special");
					special.insertLast(currentQ.removeFirst());
				}
				
				if (special.size() == neededLength && !currentQ.isEmpty()) {
					while (!temp.isEmpty()) {
						currentQ.insertFirst(temp.removeLast());
					}
				} else {
					while (!temp.isEmpty()) {
						currentQ.insertLast(temp.removeFirst());
					}
				}	
			}
			
		}
		// if special still has no data
		if (special.isEmpty()) {
			special.insertLast(counters[counters.length-1].removeLast());
		}
		
	}

}
