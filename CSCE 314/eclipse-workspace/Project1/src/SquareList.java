import java.util.Iterator;
import java.util.LinkedList;

// whole new file, toplevellist
/*class dllNode {
	Integer elem;
	dllNode next;
	dllNode prev;

	// Is this what we need to tie in innerlist?
	dllNode cross;
	// Confused at how it will work, since SquareList holds "Integer"'s
}*/

// via Lupoli in OH (7/27): should only have three classes, four is WRONG
public class SquareList {

	// need innerlist IN THE LIST. pun intended
	private LinkedList<innerlist> SqrLis;
	private int sizer;
	//protected static innerlist innerLis;

    // default constructor: initializes a SquareList properly in O(1)
    public SquareList() {

    	SqrLis = new LinkedList<>();
    	/*head.next = tail;
    	head.prev = null;
    	head.elem = null;
    	head.cross = null;

    	tail.prev = head;
    	tail.next = null;
    	tail.elem = null;
    	tail.cross = null;*/

    	sizer = 0;

    }

    // description in first pages of doc.
    // Runs O(sqrt(n)) time not counting splits.
    // Splits should take time proportional to the length of the inner list that is split
    public void consolidate() { // we run this after every add or remove operation
    	/*int i = 0;
    	int n = SquareList.size();
    	int lowerbound = (int) (Math.sqrt(n) / 2);
    	int upperbound = (int) (Math.sqrt(n) * 2);

    	// traverse the top level list
    	while (i < SquareList.size()) {

    		// whenever an empty inner list is encountered, remove that inner list
    		if (innerlist.at(i).size() <= 0) {
    			next.remove(i);
    		}

    		// whenever two adjacent short inner lists are encountered, merge them into a single inner list
    		if (innerlist.at(i).size() < lowerbound) {
    			innerlist.at(i).merge(list[0]);
    		}

    		// whenever an inner list is found to have more then 2* sqrt(n) items split
    		if (innerlist.at(i).size() > upperbound)

    		// continue
    		i++;
    	}*/
    	// Like C++ we can use interators
    	// iterator that will be used to traverse our DLL in SqrLis
    	Iterator<innerlist> it = SqrLis.iterator();
    	int size = 0; int tempSize = 0; // interchange size, one will be updated
    	innerlist list = null; innerlist tempList = null;

    	// traversing top-level list or our DLL in O(sqrt(n))
    	while(it.hasNext()) {

    		// updates of O(1)
    		tempList = it.next();
    		tempSize = tempList.innersize();

    		// whenever an empty inner list is encountered, remove that inner list
    		if (tempSize == 0) { // here we can call remove, a function we implemented, for easy
    			it.remove();
    		}

    		// whenever two adjacent short inner lists are encountered, merge them into a single inner list
    		else if (( tempSize <= (Math.sqrt(this.sizer) / 2) ) && ( size <= (Math.sqrt(this.sizer) / 2) )) {

    			// make sure that the list is not empty before merging
    			if (!(list == null)) {
    				list.merge(tempList);
    				it.remove();
    			}
    		}

    		// whenever an inner list is found to have more than 2*sqrt(n) items, split them into two lists of equal length
    		else {
    			break;
    			// but we shouldn't because we will mess up the previous conditionals
    			// do it after the while loop concludes
    		}
    	}

    	// whenever an inner list is found to have more than 2*sqrt(n) items, split them into two lists of equal length
    	if ( tempSize > 2 * Math.sqrt(this.sizer) ) {

    		// We need to create a new inner list in order for the split to happen
    		innerlist tempInnerList = tempList.split();

    		// Move second half to new inner list
    		//SqrLis.add(SqrLis.indexOf(tempList)++, tempInnerList);
    		SqrLis.add(SqrLis.indexOf(tempList)+1, tempInnerList);

    	}
    } // fin. most important function...

    // Two methods to insert at begin and end of a SquareList.
    // These should call consolidate() after insertion.
    // Must run in constant time, not counting the time for consolidate.
    public void addFirst (Integer data) {
    	/*Node temp = new Node(data);
    	temp.next = head;
    	temp.prev = null;

    	if (head != null) {
    		head.prev = temp;
    	}

    	head = temp;*/

    	// the most basic case, the empty list
    	if (sizer == 0) {

    		// create a new list to be added to
    		innerlist tempList = new innerlist();

    		// add the new elem
    		tempList.addFirstHelper(data);

    		// add to top level list
    		SqrLis.addFirst(tempList);
    	}

    	// if sizer > 0
    	else {
    		SqrLis.getFirst().addFirstHelper(data);
    	}

    	// DONT FORGET TO INCREMENT SIZE AFTER ADD
    	// (and decrement for remove)
    	sizer++;

    	// Call consolidate after adding
    	consolidate();
    } // push front

    public void addLast (Integer data) {

    	// the most basic case - the empty list
    	if (sizer == 0) {

    		// create a new list to be added to
    		innerlist tempList = new innerlist();

    		// add the new elem
    		tempList.addLastHelper(data);

    		// add to top level list
    		SqrLis.addLast(tempList);
    	}

    	// of sizer > 0
    	else {
    		SqrLis.getLast().addLastHelper(data);
    	}

    	// DONT FORGET TO INCREMENT SIZE AFTER ADD
    	// (and decrement for remove)
    	sizer++;

    	// Call consolidate after adding
    	//consolidate();

    	/*if (prev == null) {
    		System.out.println("prev is null");
    		return;
    	}

    	Node temp = new Node(data);
    	temp.next = prev.next;
    	prev.next = temp;
    	temp.prev = prev;

    	if (temp.next != null) {
    		temp.next.prev = temp;
    	}*/

    	consolidate();
    } // push back

    // remove the item at the beginning of a SquareList.
    // Return the Integer value that was at the beginning of the list or null if the list was empty.
    // Call consolidate() after removal.
    // removeFirst() should run in constant time not counting the time for consolidate().
    public Integer removeFirst() {
    	/*if (innerlist = null) {
    		innerlist.headnode = null;
    		innerlist.tailptr = headnode;
    		return null;
    	}
    	return null;*/
    	// stay in bounds
    	if (!(sizer == 0)) {

    		// perform the removal
    		Integer elem = SqrLis.get(0).removeFirstHelper(0);

    		// DONT FORGET TO DECREMENT SIZE AFTER REMOVE
    		// (and increment for add)
    		sizer--;

    		// Call consolidate after removal
    		consolidate();

    		// return the Integer value removed
    		return elem;
    	}

    	// you're out of bounds!
    	return null;
    }

    // add an item at a given position of a SquareList.
    // Positions start at 0.
    // So add(0,5) should insert 5 at the begin of list.
    // Also if a square list originally held 1,2,3,4,5, then after add (2,99) the list should hold 1,2,99,3,4,5.
    // If pos is not valid, this method should do nothing
    // This method should call consolidate() after insertion.
    // The add() method should take O(sqrt(n)) time not counting the time for consolidate().
    public void add(int pos, Integer data) {


    	/*Node newNode = new Node();
    	newNode.element = data;
    	newNode.next = null;
    	newNode.prev = null;

    	if (pos < 1 ) {
    		System.out.println("Position too small! Enter pos >= 1.");
    	}
    	else if (pos == 1) {
    		newNode.next = head;
    		head.prev = newNode;
    		head = newNode;
    	}
    	else {
    		Node tempNode = new Node();
    		tempNode = head;
    		for (int i = 1; i < pos - 1; i++) {
    			if (tempNode != null) {
    				tempNode = tempNode.next;
    			}
    		}

    		if (tempNode != null) {
        		newNode.next = tempNode.next;
        		newNode.prev = tempNode;
        		tempNode.next = newNode;

        		if (newNode.next != null) {
        			newNode.next.prev = newNode;
        		}
        		else {
        			System.out.println("Prev is null.");
        		}
        	}
    	}*/
    	// stay in bounds
    	if (pos >= 0) { // lower bound
    		if (pos <= this.sizer) { // upper bound

    			// Initialize iterator and old/new sizes
    			Iterator<innerlist> it = SqrLis.iterator();
    			int oldsize = 0; int newsize = 0;

    			// iterate through the list while it has a next place to go
    			while (it.hasNext()) {

    				// update new pointer
    				innerlist newer = it.next();

    				// update new size
    				newsize = newsize + newer.innersize();

    				// stay in bounds
    				if (pos <= newsize - 1) {

    					// placeholder for inserting new, update pos
    					int updatePos = pos - oldsize;

    					// perform the add with update pos
    					newer.addHelper(data, updatePos);

    					// call consolidate after add
    					consolidate();

    					// DONT FORGET TO INCREMENT SIZE AFTER ADD
    					// (and decrement for remove)
    					sizer++;
    					break;
    				}

    				// update the old size and continue
    				oldsize = newsize;
    			}
    		}
    	}


    }

 // remove an item from a given position of a SquareList and return its value.
    // As with add(), positions start at 0.
    // If list holds 1,2,3,4,5, then after remove(3) the list hold 1,2,3,4.
    // If pos invalid, this method returns null.
    // Call consolidate() after removal.
    // Take O(sqrt(n)) time not counting time for consolidate().
    public Integer remove(int pos) {

    	// initialize an iterator for traversal
    	Iterator<innerlist> it = SqrLis.iterator();

    	// initialize placeholders for old and new sizes
    	int oldsize = 0; int newsize = 0;

    	// traverse the list while it has a next to go to
    	while (it.hasNext()) {

    		// keep track of currptr and update size
    		innerlist currptr = it.next();
    		newsize = newsize + currptr.innersize();

    		// stay in bounds
    		if (pos < newsize) {

    			// update pos
    			int updatePos = pos - oldsize;

    			// store what we remove for returning with update pos
    			Integer toDelete = currptr.getHelper(updatePos);

    			// perform the removal with update pos
    			currptr.removeHelper(updatePos);

    			// DONT FORGET TO DECREMENT SIZE FOR REMOVE
    			// (and increment for add)
    			sizer--;

    			// return the stored removal
    			return toDelete;
    		}

    		// update size
    		oldsize = newsize;
    	}

    	// if not found or out of bounds
    	return null;
    }

    // return the value of an item at a given position of a SquareList.
    // Positions start at 0
    // If square list holds 1,2,3,4,5, get(2) returns 3.
    // If pos invalid, this method returns null.
    // Takes time O(sqrt(n))
    public Integer get(int pos) {

    	// initialize an iterator for traversal of innerlist
    	Iterator<innerlist> it = SqrLis.iterator();

    	// keep track of size
    	int oldsize = 0; int newsize = 0;

    	// traversal while true
    	while (it.hasNext()) {

    		// keep track of currptr and update size
    		innerlist currptr = it.next();
    		newsize += currptr.innersize();

    		// stay in bounds
    		if (pos < newsize) {

    			// update pos
    			int updatePos = pos - oldsize;

    			// perform the accessor with update pos
    			return currptr.getHelper(updatePos);
    		}

    		// update size
    		oldsize = newsize;
    	}

    	// if not found or out of bounds
    	return null;
    }

    // change the value of an item at a given position of a SquareList
    // Positions start with 0
    // If list holds 1,2,3,4,5, after set(2,99) list holds 1,2,99,4,5.
    // Takes time O(sqrt(n))
    public void set(int pos, Integer data) {
    	/*Node ptr = innerlist.head;
    	int trav = 0;
    	while (ptr != null) {
    		if (trav = pos) {
    			innerlist.Node.data = data;
    		}
    		trav++;
    		ptr = ptr.next;
    	}*/
    	// initialize an iterator for traversal
    	Iterator<innerlist> it = SqrLis.iterator();

    	// keep track of sizes
    	int oldsize, newsize;
    	oldsize = 0; newsize=0;

    	// traverse while true
    	while (it.hasNext()) {

    		// keep track of currptr
    		innerlist currptr = it.next();

    		// update size
    		newsize = newsize + currptr.innersize();

    		// stay in bounds
    		if (pos < newsize) {

    			// update pos
    			int updatePos = pos - oldsize;

    			// perform the mutator with update pos
    			currptr.setHelper(updatePos, data);
    		}

    		// update size
    		oldsize = newsize;
    	}
    }

    // returns the number of items in a SquareList
    // runs constant time
    public int size()  { return sizer; }

    // returns the position of the first occurrence of a value in a SquareList
    // If data does not appear in the list, this returns -1
    // Positions start at 0
    // If list holds 1,2,3,4,5, indexOf(5) returns 4
    // Runs O(n) time
    public int indexOf(Integer data)  {

    	// initialize an iterator for traversal
    	Iterator<innerlist> it = SqrLis.iterator();
    	int pos = 0;

    	// traverse while true
    	while (it.hasNext()) {

    		// keep track of currptr
    		innerlist currptr = it.next();

    		// keep track of current Node
        	Node<Integer> currentNode = currptr.indexOfHelper().getNext();

        	// traverse
        	for (int i = 0; i < currptr.innersize(); i++) {

        		// check if empty list
        		if (currentNode != null) {

        			// GOTCHA, found a match
        			if (currentNode.getElem().equals(data)) {

        				// return the matching index of
        				return i+pos;
        			}
        		}

        		// update current node to continue traversal
        		currentNode = currentNode.getNext();
        	}

        	// update pos
        	pos = pos + currptr.innersize();
    	}

    	/*int index = 0;
    	Node curr = head;

    	// traverse
    	while (curr != null) {
    		// found
    		if (curr.data = data) {
    			return index;
    		}
    		// not found
    		curr = curr.getNextSibling();
    		index++;
    	}*/

    	// not found or out of bounds
    	return -1;
    }

    // a debugging method
    // print out the size of the SquareList and for each inner list, the size of the inner list, each item in the inner list and the item tha the tail pointer references.
    // The output should clearly indicate where an inner list begins and ends
    // Run time does not matter because is for debugging only
    // Implement in the most reliable manner possible (avoid calls to methods which might themselves be buggy)
    public void dump()  {
    	/*Node ptr = head;
    	Node tempIL = innerlist.head;
    	int sizeSL = 0; // SquareList size
    	int sizeIL = 0; // innerlist size
    	while (ptr != null) {
    		if (ptr.innerlist != null) {
    			sizeSL++;
    			System.out.println("inner list begin...");
    			while (ptr.innerlist.tempIL != null) {
    				System.out.println(tempIL.data);
    				sizeIL++;
    			}
    			System.out.println(innerlist.tail.next.data);
    			System.out.println("inner list ended...");
    			System.out.pritln("innerlist size: " + sizeIL);
    		}
    		ptr = ptr.next;
    	}
    	System.out.println("SquareList size: " + sizeSL);*/
    	System.out.println("Dumping initialized...");
    	System.out.println("Overall sizes = " + sizer + ", and number of lists = " + SqrLis.size());

    	// traverse and print
    	for (innerlist element : SqrLis) {
    		element.dumpHelper();
    	}
    	System.out.println("Dumping terminated...\n");
    }

    // plug in file io here
}
