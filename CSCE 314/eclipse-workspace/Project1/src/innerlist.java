public class innerlist {

	// For all data or elem, use Integer
	// Everything else should be int

	// Head and tail "dummy nodes"
	private Node<Integer> header;
	private Node<Integer> trailer;

	// private/protected size variable (allows O(1) implementation(s)
	private int sizer;

	// default constructor that properly initiates an inner list
	public innerlist() {

		// Starting node
		Node<Integer> temp = new Node<>();

		// Point header and trailer to starting for initial list
		header = temp; trailer = temp;
		sizer = 0;
	}

	// merges two inner lists in constant time
	// link the current tail to the next list's front end
	// update tails and sizes
    public void merge(innerlist other) { // argument was wrong, needs to be other list
    	this.trailer.setNext(other.header.getNext());
    	this.trailer = other.trailer;
    	this.sizer += other.sizer;
    }

    // reports the length of an inner list in constant time
    public int innersize() { return this.sizer; }

    // indexOf helper
    public Node<Integer> indexOfHelper() { return header; }

    // get helper -- allows accessing in innerlist
    public Integer getHelper (int n) {

    	// stay in bounds
    	if (n >= 0) { // lower bound
    		if (n < sizer) { // upper bound

    			// keep track of currptr
    			Node<Integer> currptr = header.getNext();

    			// traverse till n is reached
    			for (int i = 0; i < n; i++) {

    				// update currptr
    				currptr = currptr.getNext();
    			}

    			// perform the accessor
    			return currptr.getElem();
    		}
    	}

    	// if out of bounds, or not found, or empty list
    	return null;
    }

    // set helper -- allows mutating in innerlist
    public void setHelper(int n, Integer elem) {

    	// stay in bounds
    	if (n >= 0) { // lower bound
    		if (n < sizer) { // upper bound

    			// keep track of currptr
    			Node<Integer> currptr = header.getNext();

    			// traverse till n is reached
    			for (int i = 0; i < n; i++) {

    				// update currptr
    				currptr = currptr.getNext();
    			}

    			// perform the mutator, no returns in mutators
    			currptr.setElem(elem);
    		}
    	}
    }

    // divides an inner list into two lists of about equal size (differ at most by 1).
    // O(t) time where t is length of original inner list
    public innerlist split() {

    	// initialize a new list and it's header and trailer, and size and currptr
    	innerlist tempList = new innerlist();

    	// initialize the new list's header and trailer to null
    	Node<Integer> tempHeader = null; Node<Integer> tempTrailer = null;

    	// initialize the new size to half the actual
    	int tempSizer = this.sizer/2;

    	// keep track of current pointer
    	Node<Integer> currptr = this.header.getNext();

    	/*// check if list is empty
    	// if yes, head and tail each other.
    	if (length == 0) {
    		headnode = null;
    		tailptr = headnode;
    		return null;
    	}*/

    	// traversal of new list
    	for (int i = 0; i < tempSizer; i++) {

    		// update current pointer
    		currptr = currptr.getNext();

    		// the split part should differ by at most 1
    		if (i == tempSizer-2) {
    			tempTrailer = currptr;
    		}
    		else if (i == tempSizer-1) {
    			tempHeader = currptr; currptr = null;
    		}
    	}

    	/*// create a new list holding nodes in second half for return
        Node tempMid = innerlist.getmidNode();
        Node tempHead = new Node(tempMid.data);
        tempMid = tempMid.next;
        tailptr = tempHead;
        innerlist.Node tempNode = null;
		tailptr = tempNode;
        while (tempMid != null) {
        	tempNode = new Node(tempMid.data);
        	tailptr.next = tempNode;
        	tailptr = tempNode;
        }
        innerlist.length /= 2;
        return tempHead;*/




    	// update the header and trailer pointers and nodes
    	tempTrailer.setNext(null); // this is end of list, which points to null
    	tempList.header.setNext(tempHeader); // after split this is the new head node
    	tempList.trailer = this.trailer; // both tails end up being null after split
    	this.trailer = tempTrailer;

    	// update the sizes of old and new list after split
    	if (!(this.sizer % 2 == 0)) { // SHOULD DIFFER BY AT MOST ONE
    		this.sizer = tempSizer;
    		tempList.sizer = tempSizer++;
    	}

    	// the split was even and no housekeeping needed
    	if (this.sizer % 2 == 0) {
    		tempList.sizer = tempSizer;
    		this.sizer = tempSizer;
    	}

    	// return the second half of the split, or the second list, or the temp list
    	return tempList;
    }

    /*// first find the middle node,
    // then create the new list from the middle node as second half,
    // via creating new node that traverses from mid to tail.
    private static Node getmidNode() {
    	if (sizer == 0) {
    		header = null;
    		tailptr = headnode;
    		return null;
    	}
    	Node firstHalf = headnode, secondHalf = headnode;
    	while (firstHalf != null && firstHalf.next != null) {
    		secondHalf = secondHalf.next;
    		firstHalf = firstHalf.next.next;
    	}
    	return secondHalf;
    }*/


    // add first helper
    public void addFirstHelper(Integer elem) {

    	// the most basic case - the empty list
    	if (sizer == 0) {

    		// create a node to be added
    		Node<Integer> tempNode = new Node<> (elem, null);
    		header.setNext(tempNode);
    		trailer = tempNode;
    	}

    	// if there are already existing nodes
    	else {
    		Node<Integer> tempNode = new Node<> (elem, header.getNext());
    		header.setNext(tempNode);
    	}

    	// DONT FORGOT TO INCREMENT SIZE FOR ADD
    	// (and decrement for remove)
    	sizer++;
    }

    public void addLastHelper(Integer elem) {

    	// create a new node to be added
    	Node<Integer> tempNode = new Node<> (elem, null);

    	// the most basic case - the empty list
    	// if true, head would point to the only node
    	if (sizer == 0) {
    		header.setNext(tempNode);
    	}

    	// if false, tail would point to it
    	else {
    		trailer.setNext(tempNode);
    	}

    	// update the tail
    	trailer = tempNode;

    	// and DONT FORGET SIZE INCREMENT
    	sizer++;
    }

    public Integer removeFirstHelper(int n) {

    	// Keep track of currptr
    	Node<Integer> currptr = header;

    	// stay in bounds
    	if (n >= 0) { // lower bound
    		if (n < sizer) { // upper boud

    			// traverse
    			for (int i = 0; i < n; i++) {

    				// update currptr
    				currptr = currptr.getNext();
    			}

    			// GOTCHA, now remove
    			// Placeholder for remove node
    			Node<Integer> toDeleteNode = currptr.getNext().getNext();

    			// Placeholder for remove elem
    			Integer toDeleteElem = currptr.getNext().getElem();

    			// the most basic case - the empty list housekeeping
    			if (currptr.getNext() == trailer) {
    				trailer = currptr;
    			}

    			// update pointers to stay in bounds
    			currptr.getNext().setNext(null);
    			currptr.setNext(toDeleteNode);

    			// DONT FORGET TO DECREMENT SIZE AFTER REMOVAL
    			// (and increment for add)
    			sizer--;

    			// return what was deleted
    			return toDeleteElem;
    		}
    	}
    	// the position was invalid, out of bounds, or not found
		return null;
    }

    // add helper
    public void addHelper(Integer elem, int n) {

    	// keep track of currptr
    	Node<Integer> currptr = header;

    	// stay in bounds
    	if (n >= 0) { // lower bound
    		if (n <= sizer) { // upper bound

    			// traverse
    			for (int i = 0; i < n; i++) {

    				// update currptr
    				currptr = currptr.getNext();
    			}

    			// create the new node and perform the insert
    			Node<Integer> toInsert = new Node<> (elem, currptr.getNext());

    			// update currptr to perform insert properly
    			currptr.setNext(toInsert);

    			// if the list was orginally empty, the basic case
    			if (currptr == trailer) {
    				trailer = toInsert;
    			}

    			// DONT FORGET TO INCREMENT SIZE AFTER ADD
    			// (and decrement for remove)
    			sizer++;
    		}
    	}
    }

    public Integer removeHelper (int n) {

    	// keep track of currptr
    	Node<Integer> currptr = header;

    	// stay in bounds
    	if (n >= 0) {// lower bound
    		if (n < sizer) {// upper bound

    			// traverse
    			for (int i = 0; i < n; i++) {

    				// update currptr to continue traversal
    				currptr = currptr.getNext();
    			}

    			// placeholder for removal node
    			Node<Integer> toDeleteNode = currptr.getNext().getNext();

    			// placeholder for removal element
    			Integer toDeleteElem = currptr.getNext().getElem();

    			// the most basic case - the empty list
    			if (currptr.getNext() == trailer) {

    				// update trailer since there's no more nodes and empty list
    				trailer = currptr;
    			}

    			// update pointers housekeeping
    			currptr.getNext().setNext(null);
    			currptr.setNext(toDeleteNode);

    			// DONT FORGET TO DECREMENT SIZE AFTER REMOVE
    			// (and increment for add)
    			sizer--;

    			// return what was deleted
    			return toDeleteElem;
    		}
    	}

    	// if the position was invalid or empty list, or out of bounds
    	return null;
    }

    public void dumpHelper() {
    	Node<Integer> currptr = header.getNext();
    	System.out.println("innerlist::dumpHelper initialized...");
    	System.out.println("size: " + sizer);

    	// traverse till the end
    	while (!(currptr == null)) {
    		System.out.println("[" + currptr.getElem() + "] ");

    		// update currptr to keep going
    		currptr = currptr.getNext();
    	}
    	System.out.println();
    	System.out.println("Tail's Elem: " + trailer.getElem());
    }
}