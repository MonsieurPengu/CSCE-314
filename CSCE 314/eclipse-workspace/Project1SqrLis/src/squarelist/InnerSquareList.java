// Name: Ian Wang
// Section: CSCE 314 700 - Group 28
// UIN: 227004716
package squarelist;

// the inner list is a singly linked list
// that is connected to a top level list
// where top level list is a doubly linked list
public class InnerSquareList {
	
	// For all data or elem, use Integer
		// Everything else should be int

		// Head and tail "dummy nodes"
	// class members
	private Node<Integer> header;
	private Node<Integer> trailer;
	private int sizer; // private/protected size variable (allows O(1) implementation(s)
	
	// default constructor that properly initializes a InnerSquareList
	public InnerSquareList() {
		Node<Integer> temp = new Node<Integer>();
		
		// The list will be empty in the beginning
		header = temp;
		trailer = temp;
		sizer = 0;
	}
	
// REQUIRED FUNCTIONS
	// The original parameter was wrong - needs to be other list
	// merges two inner lists in constant time
	public void merge(InnerSquareList anotherlist) {
		
		// We need to link the tail of an inner list to 
		// the adjacent list's first node.
		// Dont forget: Update the tails and the sizes
		this.trailer.setNext(anotherlist.header.next());
		this.trailer = anotherlist.trailer;
		this.sizer += anotherlist.sizer;
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
	
	// size 
	// reports the length of an inner list in constant time
	public int size() {
		return this.sizer;
	}
	
	// split
	// if a list is bigger than 2*sqrt(n) then split in half
	// the halves should only differ by at most 1 elem
	public InnerSquareList split() {
		
		// Create a new list to put the second half of split list
		InnerSquareList tempList = new InnerSquareList();
		
		// Create new header for new list
		Node<Integer> tempHeader = null;
		
		// Create new trailer for new list
		Node<Integer> tempTrailer = null;
		
		// Create new size for new list
		int tempSizer = this.sizer/2;
		
		// Keep track of currptr for traversal
		Node<Integer> currptr = this.header.next();
		
		// traverse the list till the halfway point - tempSize
		for (int currpos = 0; currpos < tempSizer; currpos++) {
			
			// update currptr to continue traversal
			currptr = currptr.next();
			
			// if difference in halves is 2
			if (currpos==tempSizer-2) {
				
				// update the tail since we can differ only by 1
				tempTrailer = currptr;
			}
			
			// if difference in halves is 1
			if (currpos==tempSizer-1) {
				
				// our maximum difference
				tempHeader = currptr;
				currptr = null;
			}
		}
		
		// update tail ptr to be end of list so null
		tempTrailer.setNext(null);
		
		// update header of the second half to it's new head
		tempList.header.setNext(tempHeader);
		
		// update trailer of the second half to null
		tempList.trailer = this.trailer;
		this.trailer = tempTrailer;
		
		// We can differ at most by 1, thus update sizes
		if (this.sizer%2 != 0) {
			
			// first half is half the original size
			this.sizer = tempSizer;
			
			// second half is one larger at most
			tempList.sizer = tempSizer+1;
		}
		else { // if the two halves were of even size from split
			
			// both sizes will be half orginal size
			// second half
			tempList.sizer = tempSizer;
			
			// first half
			this.sizer = tempSizer;
		}
		
		// return the second half of the split as a list
		return tempList;
		
		/*// check if list is empty
    	// if yes, head and tail each other.
    	if (length == 0) {
    		headnode = null;
    		tailptr = headnode;
    		return null;
    	}*/
		/*// create a new list holding nodes in second half for return
        Node tempMid = InnerSquareList.getmidNode();
        Node tempHead = new Node(tempMid.data);
        tempMid = tempMid.next;
        tailptr = tempHead;
        InnerSquareList.Node tempNode = null;
		tailptr = tempNode;
        while (tempMid != null) {
        	tempNode = new Node(tempMid.data);
        	tailptr.next = tempNode;
        	tailptr = tempNode;
        }
        InnerSquareList.length /= 2;
        return tempHead;*/

	}
	
// ACCESSORS AND MUTATORS
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
	
	// accessing the first node - head
	public Node<Integer> getFirst() {
		return header;
	}
	
// HELPER FUNCTIONS
	
	// get function - the accessor
	public Integer getHelper(int n) {
		
		// stay in bounds
		if (n>=0) { // lower bound
			if (n<sizer) { // upper bound
				
				// keep track of currptr
				Node<Integer> currptr = header.next();
				
				// traverse till n is reached
				for (int i = 0; i < n; i++) {
					
					// update currptr as needed
					currptr = currptr.next();
				}
				
				// perform the accessor's job once position found
				return currptr.elem();
			}
		}
		
		// if out of bounds
		return null;
	}
	
	// set function - the mutator
	public void setHelper(int n, Integer elem) {
		
		// stay in bounds
		if (n>=0) { // lower bound
			if (n<sizer) { // upper bound
				
				// keep track of currptr
				Node<Integer> currptr = header.next();
				
				// traverse till n is reached
				for (int i = 0; i < n; i++) {
					
					// update currptr as needed
					currptr = currptr.next();
				}
				
				// perform the mutator's job
				currptr.setElem(elem);
				// No return for void
			}
		}
	}

// HELPER FUNCTIONS!!!
	// insert helper
	public void addHelper(Integer elem, int n) {
		
		// keep track of currptr
		Node<Integer> currptr = header;
		
		// stay in bounds
		if (n >= 0) { // lower bound
			if (n <= sizer) { // upper bound
				
				// traverse till n is reached
				for (int i = 0; i < n; i++) {
					
					// update curr ptr as needed
					currptr = currptr.next();
				}
				
				// create new node to be inserted
				Node <Integer> toInsert = new Node<Integer>(elem, currptr.next());
				
				// update currptr 
				currptr.setNext(toInsert);
				
				// if the list was empty before insert 
				if (currptr == trailer) {
					trailer = toInsert;
				}
				
				// DONT FORGET TO INCREMENET SIZE FOR ADD
				// (and decrement for remove)
				sizer++;
				
			}
		}
	}
	
	// remove helper
		public Integer removeHelper(int n) {
			
			// keep track of the currptr
			Node<Integer> currptr = header;
			
			// stay in bounds
			if (n >= 0) { // lower bound
				if (n < sizer) { // upper bound
					
					// traverse till n is treached
					for (int i = 0; i < n; i++) {
						
						// update currptr to continue traversal if needed
						currptr = currptr.next();
					}
					
					// placeholder node and elem for removal process
					Node<Integer> toDeleteNode = currptr.next().next();
					Integer toDeleteElem = currptr.next().elem();
					
					// the most basic case - empty list
					if (currptr.next() == trailer) {
						trailer = currptr;
					}
					
					// update currptr housekepeing
					currptr.next().setNext(null);
					currptr.setNext(toDeleteNode);
					
					// DONT FORGET TO DECREMENT SIZE FOR REMOVE
					// (and increment for add)
					sizer--;
					
					// return what was deleted
					return toDeleteElem;
				}
			}
			
			// if out of bounds, or not found, or doesnt exist
			return null;
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
	
	
	// push front
	public void addFirstHelper(Integer elem) {
		
		// the most basic case - empty list
		if (sizer == 0) {
			
			// create the new node to be inserted
			Node<Integer> temp = new Node<Integer>(elem, null);
			
			// perform insert and updates
			header.setNext(temp);
			trailer = temp;
		}
		
		// if the list already exists and has nodes within
		else {
			
			// create the new node to be inserted
			Node<Integer> temp = new Node<Integer>(elem, header.next());
			header.setNext(temp);
		}
		
		// DONT FORGET TO INCREMENT SIZE FOR ADD
		// (and decrement for remove)
		sizer++;
	}
	
	// push back
	public void addLastHelper(Integer elem) {
		
		// create the new node to be inserted
		Node<Integer> temp = new Node<Integer>(elem, null);
		
		// the most basic case - the empty list
		if (sizer == 0) {
			header.setNext(temp);
		}
		
		// list was not empty
		else {
			
			// update tail cause we are pushing at back of list
			trailer.setNext(temp);
		}
		
		// update tail
		trailer = temp;
		
		// DONT FORGET TO UPDATE SIZE AFTER ADD
		sizer++;
	}
	
	// dump helper
	public void dumpHelper() {
		
		// keep track of currptr
		Node<Integer> currptr = header.next();
		
		// Print out dump within inner list
		System.out.println("***Dump Helper - Inner List initiated...***");
		
		// report the size of inner list
		System.out.println("Inner List Size: " + sizer);
		
		// traverse through the list and report the elements
		while (currptr != null) {
			
			// dont skip lines
			System.out.print("{" + currptr.elem() + "} ");
			
			// update currptr to continue traversal till null
			currptr = currptr.next();
		}
		
		// report the elem of tail 
		System.out.println();
		System.out.println("Element of Trailer: " + trailer.elem());
		System.out.println("***Dump Helper - Inner List terminated...***");
		
	}
	
}
