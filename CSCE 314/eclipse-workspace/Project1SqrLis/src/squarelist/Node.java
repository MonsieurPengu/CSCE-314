// Name: Ian Wang
// Section: CSCE 314 700 - Group 28
// UIN: 227004716
package squarelist;
// refer to 221 Leyk - DoublyLL PA
public class Node<T> { // templated
	
	// class members - private data and nextptr
	private T elem;
	private Node<T> nextptr;
	
	// default constructor that properly initializes a node
	public Node() {
		elem = null;
		nextptr = null;
	}
	
	// parameterized constructor that assigns a element to a node
	public Node(T data, Node<T> temp) {
		this.elem = data;
		this.nextptr = temp;
	}
	
	// ACCESSORS
	// get data
	public T elem() { return this.elem; }
	
	// get next
	public Node<T> next() { return this.nextptr; }
	
	// MUTATORS
	// set elem
	public void setElem(T elem) { this.elem = elem; }
	
	// set next
	public void setNext(Node<T> temp) { this.nextptr = temp; }
}
