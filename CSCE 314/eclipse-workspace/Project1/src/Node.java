
// refer to 221 Leyk - DLL Prog. Assignment
// templated node class
// Better to separate the classes into their own files
public class Node<T> {

// members
	private T elem;
	private Node<T> nextptr;

// constructors (Java's big 3/big 5)
	// default constructor that initializes a node
	public Node() {
		elem = null; nextptr = null;
	}

	// parameterized constructor for node class
	public Node(T elem, Node<T> temp) {
		this.elem = elem; this.nextptr = temp;
	}
	//this.sqrList.next = temp;

// accessors
	// get next node via nextptr
	public Node<T> getNext() { return this.nextptr; }

	// get node element
	public T getElem() { return this.elem; }

// mutators
	// set nextptr to a diff node
	public void setNext(Node<T> temp) { this.nextptr = temp; }

	// set elem to another elem
	public void setElem(T elem) { this.elem = elem; }
}
