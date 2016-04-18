import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Iterable<T>{
	Node first=null;
	Node last=null;
	int count=0;
	
	public T pop(){
		if(first.next==last) throw new NoSuchElementException();
		T i=first.obj;
		first=first.next;
		first.prev=null;
		return i;
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	public int size(){
		return count;
	}
	public void push(T object){
		if(last==null){
			last=new Node();
			last.obj=object;
			first=last;
			count++;
		} else{
		last.next=new Node();
		last.next.prev=last;
		last=last.next;
		last.obj=object;
		count++;
		}
	}
	class Node{
		Node prev, next;
		T obj;
	}
	@Override
	public Iterator<T> iterator() {
		return new IteratorLS();
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
