
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T>{
int now=0;
	T[] mass;
	public Bag() {
		mass=(T[])new Object[1];
	}
	class IteratorBag implements Iterator<T>{
		int current = 0;
		@Override
		public boolean hasNext() {
			//if(mass[0]==null)throw new NoSuchElementException();
			if(mass.length==1)return false;
			if(current==now) return false;
			return true;
		}

		@Override
		public T next() {
			if(hasNext()) current++;
			return mass[current-1];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void add(T i){
		if(now==mass.length-1) resize(mass.length*2);
		mass[now]=i;
		now++;
	}
	public int size(){
		return now;
	}
	public boolean isEmpty(){
		return mass[0]==null;
	}
	private void resize(int n){
		T[] temp=(T[])new Object[n];
		for(int i=0;i<now;i++){
			temp[i]=mass[i];
		}
		mass=temp;
	}
	@Override
	public Iterator<T> iterator() {
		return new IteratorBag();
	}
}