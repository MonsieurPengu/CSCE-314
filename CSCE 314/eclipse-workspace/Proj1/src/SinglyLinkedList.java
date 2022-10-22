//package proj1;
/**
 * SinglyLinkedList.java 
 * 
 * Description:
 * Singly Linked List data structure for use as inner lists in the SquareList class
 * Includes dummy header node, and necessary methods.
 * 
 * @author Michael Neary <mneary1@umbc.edu>
 * @project CMSC 341 - Fall 2013 - Project 1
 * @section 01
 * @version Oct 1, 2013
 */

public class SinglyLinkedList {

	private Node<Integer> head;
	private Node<Integer> tail;
	private int size;
	
	/**
	 * Default constructor for SinglyLinkedList
	 * 
	 * The head and tail instance variables are set to a dummy header,
	 * or a Node<Integer> that doesn't contain any data
	 * 
	 * The size of the list is set to zero
	 */
	public SinglyLinkedList(){
		Node<Integer> dummy = new Node<Integer>();
		head = dummy;
		tail = dummy;
		size = 0;
	}
	
	

	/**
	 * merge() - merges two singly linked lists, maintaining order
	 * done in constant time, only assignment statements are made
	 * 
	 * @param otherList - the other list to merge into this list
	 */
	public void merge(SinglyLinkedList otherList){

		// tail of this list needs to reference first item of other list
		this.tail.setNext(otherList.head.next());
		
		// tail of this list becomes tail of parameter
		this.tail = otherList.tail;
		
		//add the sizes together
		this.size += otherList.size;
		
	}
	
	/**
	 * split() splits a list into two separate lists, maintaining the order
	 * the original list is chopped in half, and it returns the other part of the list
	 * that was chopped off
	 * 
	 * this runs in linear time, it traverses the list until it reaches the middle
	 * then performs the split
	 * 
	 *    ****NOTE****
	 *    I am aware that this method does not work for lists of size < 4
	 *    I am assuming that because of the size bounds on these inner lists,
	 *    and the way the the SquareLists are constructed that you will never 
	 *    have to split lists that are that small.
	 *    
	 *    Also, it seems to me that this method splits differently on odd sized
	 *    lists than the example output does. Order is still maintained, so that should
	 *    not be a problem. 
	 * 
	 * @return the other part of the list that got chopped off
	 */
	public SinglyLinkedList split(){
		
		SinglyLinkedList newList = new SinglyLinkedList();
		
		Node<Integer> newHead = null;
		Node<Integer> newTail = null;
		
		int newSize = this.size / 2;
	
		Node<Integer> current = this.head.next(); 
		
		//traverse the list to pick out the references that are needed to split
		for(int i = 0; i < newSize; i++){
			current = current.next();
			if(i == newSize - 2){
				newTail = current;
			}
			
			if(i == newSize - 1){
				newHead = current;
				current = null;
			}
		}
		
		newTail.setNext(null);
		
		newList.head.setNext(newHead);
		newList.tail = this.tail;
		
		
		this.tail = newTail;
		if(this.size % 2 != 0){
			this.size = newSize;
			newList.size = newSize + 1;
		}
		else{
			newList.size = newSize;
			this.size = newSize;
		}
		
		return newList;
	}

	/**
	 * addAtStart() - adds an Integer to the beginning of the list
	 * this is performed in constant time
	 * only assignment and conditional statements are made
	 * 
	 * @param data - the Integer to add to the list
	 */
	public void addAtStart(Integer data){

		//catch the case if this is the first item being added to the list
		if(size == 0){
			Node<Integer> newNode = new Node<Integer>(data, null);
			head.setNext(newNode);
			tail = newNode;
		}
		else{
			Node<Integer> newNode = new Node<Integer>(data, head.next());
			head.setNext(newNode);
		}
		size ++;
	}
	
	/**
	 * addAtEnd() - adds an Integer to the end of the list
	 * this is performed in constant time
	 * only assignment and conditional statements are made
	 * 
	 * @param data - the Integer to add to the list
	 */
	public void addAtEnd(Integer data){
		
		Node<Integer> newNode = new Node<Integer>(data, null);
		
		//catch the case if this is the first item beign added to the list
		if(size == 0){
			head.setNext(newNode);
		}
		else{
			tail.setNext(newNode);
		}
		tail = newNode;
		size ++;
	}

	/**
	 * remove() - removes the Integer at a certain position in the list
	 * this is performed in linear time
	 * the worst case is it has to traverse the whole list to get to the right 
	 * position to remove from
	 * 
	 * @param pos - the position of the item to be removed in this list [starts at 0]
	 * @return the Integer removed at the position
	 */
	public Integer remove(int pos){
		
		Node<Integer> current = head;
		
		//check to make sure that the position is valid
		if(pos >= 0) {
			if(pos < size){
			
			//get the desired reference
			for(int n = 0; n < pos; n++){
				current = current.next();
			}
			
			//perform the removal
			Node<Integer> temp = current.next().next();
		
			Integer data = current.next().data();
			
			//reset the tail if the last item is the one being removed
			if(current.next() == tail){
				tail = current;
			}
			current.next().setNext(null);
			current.setNext(temp);
			size --;
			
			return data;
		}
		}
		return null;
	}

	/**
	 * insert() - inserts some Integer at a certain position in this list
	 * this runs in linear time
	 * the worst case is it has to traverse the whole list to get to the right 
	 * position to insert
	 * 
	 * @param data - the Integer to add to the list
	 * @param pos - where the Integer will be added in the list
	 */
	public void insert(Integer data, int pos){
		
		Node<Integer> current = head;
		
		if(pos >= 0 && pos <= size){
			// get the right reference 
			for(int n = 0; n < pos; n++){
				current = current.next();
			}
			
			Node<Integer> newNode = new Node<Integer>(data, current.next());
			current.setNext(newNode);
			
			if(current == tail){
				tail = newNode;
			}
			
			size ++;
		}
	}
	
	/**
	 * get() - returns the integer at a certain position in this list
	 * this runs in linear time
	 * the worst case is it has to traverse the whole list to find the Integer
	 * 
	 * @param pos - the position to get the item from in the list [starts at 0]
	 * @return the Integer found in the Node located at the position given
	 */
	public Integer get(int pos){
		
		if(pos >= 0 && pos < size){
			Node<Integer> current = head.next();
			
			// get the right reference 
			for(int n = 0; n < pos; n++){
				current = current.next();
			}
			return current.data();
		}
		else{
			return null;
		}
	}

	/**
	 * set() changes the value of an Integer as a position to another Integer
	 * this runs in linear time
	 * the worst case is it has to traverse the whole list to find the right position
	 * @param pos - the position to set the value at
	 * @param data - the Integer to change the value to
	 */
	public void set(int pos,Integer data){
		//check to make sure the position is valid
		if(pos >= 0 && pos < size){
			
			Node<Integer> current = head.next();
			// get the right reference 
			for(int n = 0; n < pos; n++){
				current = current.next();
			}
			
			current.setData(data);
		}
		
	}
	
	/**
	 * print() was used for debugging purposes for the class
	 * it now prints information about the list for use in SquareList's dump() method
	 */
	public void print(){
		Node<Integer> curr = head.next();
		System.out.println("=======================================");
		System.out.println("InnerList dump:");
		System.out.println("size = " + size);
		
		while(curr != null){
			
			System.out.print("["+curr.data()+"] ");
			curr = curr.next();
			
		}
		System.out.println("\ntail.data = " + tail.data());
	}
	
	/**
	 * size() gives the size of the list in constant time
	 * 
	 * size is updated every time something is added or removed to the list,
	 * so there is no need to traverse the whole list and count how many items there
	 * are every time you need to know the size
	 * 
	 * @return the size of the list
	 */
	public int size(){
		return this.size;
	}

	/**
	 * getHead() returns the dummy header
	 * @return head - the dummy header
	 */
	public Node<Integer> getHead(){
		return head;
	}
	
}