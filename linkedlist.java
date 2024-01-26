package mypack;
import java.util.*;
public class linkedlist<T> implements Iterable<T>
{
	public class Node{
		T data;
		Node next;
		Node(T val){
			data = val;
			next = null;
		}
		Node(){}
	}
	
	private Node head_node = new Node();
	
	public linkedlist(){
		head_node = null;
	}
	
	public linkedlist(T val){
		head_node.data = val;
		head_node.next = null;
	}
	
	public void addAtfirst(T val){
		Node currend_node = new Node(val);
		if (head_node == null)
			head_node = currend_node;
		else
		{
			currend_node.next = head_node;
			head_node =  currend_node;
		}
	}
	
	public void addAtend(T val){
		Node currend_node = new Node(val);
		if(head_node == null)
			head_node = currend_node;
		else
		{
			Node temp = head_node;
			while(temp!=null)
			{
				if(temp.next==null)
				{
					temp.next = currend_node;
					return;
				}
				temp = temp.next;
			}
		}
	}
	
	public void printData(){
		Node temp = head_node;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void addAt(int index,T val){
		/*...................
			add the element at given index
		.....................*/
		Node currend_node = new Node(val);
		Node temp = head_node;
		if(index==0){
			addAtfirst(val);
			return;
		}
		for(int i=0;i<index;i++)
		{
			if(index-1 == i)
			{
				currend_node.next = temp.next;
				temp.next = currend_node;
				return;
			}
			if(temp == null)
				throw new ArrayIndexOutOfBoundsException("Invalid position " + index);
			else
				temp = temp.next;
		}
	}
	
	public T getData(int index){
		/*...................
			return the value in given index
		.....................*/
		
		
		if(index==0){
			return head_node.data;
		}
		Node temp = head_node;
		for(int i=1;i<index;i++){
			if(temp == null){
				throw new ArrayIndexOutOfBoundsException("Invalid position " + index);
				
			}
			temp = temp.next;
		}
		return temp.data;
	}
	
	public void deleteData(int index){
		/*...................
			delete the element in the given index
		.....................*/
		if(index==0)
			head_node = head_node.next;
		Node temp = head_node;
		Node prev = null;
		for(int i=1;i<=index;i++){
			if(temp == null){
				throw new ArrayIndexOutOfBoundsException("Invalid position " + index);
			}
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
	
	public void update(int index,T val){
		if(index==0)
			head_node.data = val;
		Node temp = head_node;
		for(int i=1;i<=index;i++){
			if(temp == null){
				throw new ArrayIndexOutOfBoundsException("Invalid position " + index);
			}
			//System.out.println(temp.data);
			temp = temp.next;
		}
		if(temp == null)
				throw new ArrayIndexOutOfBoundsException("Invalid position " + index);
		temp.data = val;
	}
	
	public void deleteAtend(){
		Node temp = head_node;
		Node prev = null;
		while(temp.next!=null)
		{
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}
	
	public int search(T val){
		/*...................
			search for the given value in the list 
			if found return the index of the given
			value otherwise return -1
		.....................*/
		Node temp = head_node;
		for(int i=0;temp!=null;i++){
			if(temp.data==val)
				return i;
			temp = temp.next;
		}
		//throw new NotFoundException("the search result not found");
		return -1;
	}
	
	public boolean contains(T val){
		/*...................
			it returns true if the list contians the given value
			otherwise false
		.....................*/
		Node temp = head_node;
		while(temp!=null){
			if(temp.data==val)
				return true;
			temp = temp.next;
		}
		return false;
	}
	
	public int length(){
		Node temp = head_node;
		int i=0;
		while(temp!=null)
		{
			temp = temp.next;
			i++;
		}
		return i;
	}
	
	public Iterator<T> iterator(){
		return new Iterator<T>() {
			Node temp = head_node;
			
			public boolean hasNext(){
				return temp!=null;
			}
			public T next(){
				T val = temp.data;
				temp = temp.next;
				return val;
			}
		};
	}
	
	public void reverse(){
		Node temp = head_node;
		linkedlist<T> rev = new linkedlist<T>(temp.data);
		while(temp.next!=null){
			temp = temp.next;
			rev.addAtfirst(temp.data);
		}
		head_node = rev.head_node;
		
	}
	
	public void concat(linkedlist<T> val){
		Node temp = head_node;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = val.head_node;
	}
}
