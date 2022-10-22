//package proj1;
import java.util.*;
/**
 * SquareList.java
 * square list data structure, made of LinkedList going across the top,
 * and SinglyLinkedList inner lists
 * 
 * @author Michael Neary <mneary1@umbc.edu>
 * @project CMSC 341 - Fall 2013 - Project 1
 * @section 01
 * @version Oct 1, 2013
 */
public class SquareList {

	private LinkedList<SinglyLinkedList> squareList;
	private int size;
	
	/**
	 * default constructor of SquareList
	 * sets it to an empty LinkedList
	 */
	public SquareList(){
		squareList = new LinkedList<SinglyLinkedList>();
		size = 0;
	}
	
	/**
	 * consolidate() cleans up this data structure after anything is added or removed
	 * It runs in sqrt(N) time, since the worst case is that is goes all the way to the right of the
	 * top level list, and then all the way down the last list
	 */
	public void consolidate(){
		Iterator<SinglyLinkedList> itr = squareList.iterator();
		//traverse the top level list
		int prevSize = 0;
		int currentSize = 0;
		SinglyLinkedList prevList = null;
		SinglyLinkedList currentList = null;
		while(itr.hasNext()){
			currentList = itr.next();
			currentSize = currentList.size();
			
			// if an empty list is encountered, remove it
			if(currentSize == 0){
				itr.remove();
			}
			//merge two short inner lists if they are adjacent
			else if(currentSize <= (Math.sqrt(this.size) / 2) &&  prevSize <= (Math.sqrt(this.size) / 2)){
				
				if(prevList != null){
				prevList.merge(currentList);
				itr.remove();
				}
			}
			else if(currentSize > 2*Math.sqrt(this.size)){
				
				// I use break here because you've found a list that needs to split
				// the list that is being iterated over cannot be modified outside of
				// the methods provided by Iterator. These do not include an add() 
				// method or something like it, so I need to break out of the loop
				// to perform the split.
				
				break;

			}
			prevList = currentList;
			prevSize = currentSize;
		}
		//perform the split if you've broken out of the loop
		if(currentSize > 2*Math.sqrt(this.size)){
			SinglyLinkedList temp = currentList.split();
			squareList.add(squareList.indexOf(currentList) + 1, temp);
		}
		
	}
	
	/**
	 * addFirst() adds an Integer to the first position in the list in constant time
	 * 
	 * @param data - the data to add to the list
	 */
	public void addFirst(Integer data){
		
		//check the case if this is the first item being added
		if(size == 0){
			SinglyLinkedList lst = new SinglyLinkedList();
			lst.addAtStart(data);
			squareList.addFirst(lst);
		}
		else{
			squareList.getFirst().addAtStart(data);
		}
		size += 1;
		consolidate();
	}
	
	/**
	 * addLast() adds an Integer to the last position in a list in constant time
	 * 
	 * @param data - the Integer being added tot he list
	 */
	public void addLast(Integer data){
		
		//check the case that this is the first item being added to the list
		if(size == 0){
			SinglyLinkedList lst = new SinglyLinkedList();
			lst.addAtEnd(data);
			squareList.addLast(lst);
		}
		else{
			squareList.getLast().addAtEnd(data);
		}
		size += 1;
		consolidate();
	}
	
	/**
	 * removeFirst() removes the first item in the list in constant time
	 * 
	 * @return - the data that was removed
	 */
	public Integer removeFirst(){
		// can't remove something that isn't there
		if(size != 0){
			Integer data = squareList.get(0).remove(0);
			size --;
			consolidate();
			return data;
		}
		return null;
	}
	
	/**
	 * add() adds an Integer to a certain position in the list in sqrt(n) time
	 * since the worse case is traversing all the way to the right of the top list, 
	 * then all the way down the last list 
	 * 
	 * @param pos - the position to add at
	 * @param data - the data to add at the position
	 */
	public void add(int pos, Integer data){
		
		//check to see if the pos is valid
		if(pos >= 0 && pos <= this.size){
			
			Iterator<SinglyLinkedList> itr = squareList.iterator();
			int prevSizeSoFar = 0;
			int sizeSoFar = 0;
			
			while(itr.hasNext()){
				
				SinglyLinkedList current = itr.next();
				sizeSoFar += current.size();
				
				//if you the position of item you want is less than the total size so far
				//current reference is the list that you will find that position in
				if(pos < sizeSoFar){
					int newPos = pos - prevSizeSoFar;
					
					current.insert(data, newPos);
					consolidate();
					size ++;
					break;
				}
				prevSizeSoFar = sizeSoFar;
			}	
		}
	}
	
	/**
	 * remove() removes the Integer located at the given position in sqrt(n) time
	 * same reason for the running time as add()
	 * 
	 * @param pos - the position to remove the Integer
	 * @return the removed Integer
	 */
	public Integer remove(int pos){
		
		Iterator<SinglyLinkedList> itr = squareList.iterator();
		int prevSizeSoFar = 0;
		int sizeSoFar = 0;
		
		while(itr.hasNext()){
			
			SinglyLinkedList current = itr.next();
			sizeSoFar += current.size();
			
			//if you the position of item you want is less than the total size so far
			//current reference is the list that you will find that position in
			if(pos < sizeSoFar){
				int newPos = pos - prevSizeSoFar;
				Integer data = current.get(newPos);
				current.remove(newPos);
				size --;
				return data;
			}
			prevSizeSoFar = sizeSoFar;
		}
		return null;
	}
	
	/**
	 * get() finds the Integer at the given position and returns it in sqrt(n) time
	 * for the same reason as add()
	 * 
	 * @param pos - the position to find
	 * @return the Integer at that position
	 */
	public Integer get(int pos){
		
		Iterator<SinglyLinkedList> itr = squareList.iterator();
		int prevSizeSoFar = 0;
		int sizeSoFar = 0;
		
		while(itr.hasNext()){
			
			SinglyLinkedList current = itr.next();
			sizeSoFar += current.size();
			
			//if you the position of item you want is less than the total size so far
			//current reference is the list that you will find that position in
			if(pos < sizeSoFar){
				int newPos = pos - prevSizeSoFar;
				
				return current.get(newPos);
			}
			prevSizeSoFar = sizeSoFar;
			
		}
		return null;
	}

	/**
	 * set() changes the value of an Integer at a specified position in sqrt(n) time
	 * for the same reason as add()
	 * 
	 * @param pos - the position to change the data in
	 * @param data - what the change will be
	 */
	public void set(int pos, Integer data){
		Iterator<SinglyLinkedList> itr = squareList.iterator();
		int prevSizeSoFar = 0;
		int sizeSoFar = 0;
		while(itr.hasNext()){
			SinglyLinkedList current = itr.next();
			sizeSoFar += current.size();
			if(pos < sizeSoFar){
				int newPos = pos - prevSizeSoFar;
				
				current.set(newPos, data);
			}
			prevSizeSoFar = sizeSoFar;
		}
	}
	
	/**
	 * size() gives the total size of the list
	 * @return size - the total amount of items in every inner list
	 */
	public int size(){
		
		return size;
	}
	
	/**
	 * indexOf returns the index of the Integer desired, -1 if the integer is not there
	 * runs in linear (n) time, since the length of each side of the list is bounded by sqrt(n)
	 * 
	 * @param data - the Integer we're looking for
	 * @return the index the integer is at, or -1 if it's not in the list
	 */
	public int indexOf(Integer data){
		
		Iterator<SinglyLinkedList> itr = squareList.iterator();
		int n = 0;
		while(itr.hasNext()){
			
			 SinglyLinkedList current = itr.next();
			 Node<Integer> curr = current.getHead().next();
			 
			 for(int i = 0; i < current.size(); i++){
				 if(curr != null && curr.data().equals(data)){
					 return i + n;
				 }
				 curr = curr.next();
			 }
			 n += current.size();
		}
		return -1;
	}
	
	/**
	 * dump() prints out the state of everything for debugging purposes
	 */
	public void dump(){
		System.out.println("*********************************************");
		System.out.println("Total size: " + size + ", # of lists: " + squareList.size());
		for(int i = 0; i < squareList.size() ; i++){
			
			squareList.get(i).print();
		}
		System.out.println("*********************************************");
		System.out.println();
	}
	
}