import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements Iterable<T>{
	Node first=null;
	Node last=null;
	int count=0;
	
	public T pop(){
		if(last.prev==null) throw new NoSuchElementException();
		last=last.prev;
		Node a=last.next;
		last.next=null;
		count--;
		return a.obj;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	public int size(){
		return count;
	}
	public void push(T i){
		if(last==null){
			last=new Node();
			last.obj=i;
			first=last;
			count++;
		} else{
		last.next=new Node();
		last.next.prev=last;
		last=last.next;
		last.obj=i;
		count++;
		}
	}
	@Override
	public Iterator<T> iterator() {
		return new IteratorLS();
	}
	
	class Node{
		Node prev, next;
		T obj;
	}
	class IteratorLS implements Iterator<T>{
		Node current = first;
		@Override
		public boolean hasNext() {
			return current.next!=null;
		}

		@Override
		public T next() {
			if(hasNext()) current=current.next;
			return current.prev.obj;
		}
		
	}
}
