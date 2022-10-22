//package proj1;
/**
 * Node class. 
 * One single element of a singly linked list. 
 * 
 * @author Michael Neary <mneary1@umbc.edu>
 * @project CMSC 341 - Fall 2013 - Project 1
 * @section 01
 * @version Oct 1, 2013
 */
public class Node<T> {
	
	private T data;
	private Node<T> next;
	
	/**
	 * Default constructor for Node
	 */
	public Node(){
		data = null;
		next = null;
	}
	
	/**
	 * Constructor for Node
	 * 
	 * @param data - information to be stored in the Node
	 * @param node - reference to another Node
	 */
	public Node(T data, Node<T> node){
		
		this.data = data;
		this.next = node;
		
	}
	
	/**
	 * Accessor method for the data in the Node
	 * @return the data in the node
	 */
	public T data(){
		return this.data;
	}
	
	/**
	 * Accessor method for the next Node (the Node that this Node references)
	 * 
	 * @return a reference to the next node
	 */
	public Node<T> next(){
		return this.next;
	}
	
	/**
	 * Mutator method for the next parameter
	 * allows the next node to be changed as necessary
	 * @param node - the node to change the next parameter to
	 */
	public void setNext(Node<T> node){
		this.next = node;
	}
	
	/**
	 * Mutator method for the data parameter
	 * allows the data in a Node to be changed as necessary
	 * @param data - the data to change the current data to 
	 */
	public void setData(T data){
		this.data = data;
	}
}