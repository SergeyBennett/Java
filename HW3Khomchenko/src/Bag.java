import java.util.Iterator;
import java.util.NoSuchElementException;

class Bag<T>implements Iterable<T>{
	int last=0;
	T[] volume;
	public Bag() {
		volume=(T[])new Object[1];
	}
	
	public void add(T i){
		if(last==volume.length-1) enlarge();
		volume[last++]=i;
	}
	public int size(){
		return last;
	}
	public boolean isEmpty(){
		return volume[0]==null;
	}
	private void enlarge(){
		T[] temp=(T[])new Object[volume.length*2];
		for(int i=0;i<last;i++){
			temp[i]=volume[i];
		}
		volume=temp;
	}
	public void writeAll(){
		String result="["+volume[0];
		for(int i=1;i<volume.length;i++){
			result+=", "+volume[i];
		}
		System.out.println( result+="]");
	}
	@Override
	public Iterator<T> iterator() {
		return new IteratorBag();
	}
	class IteratorBag implements Iterator<T>{
		int current = 0;
		@Override
		public boolean hasNext() {
			//if(mass[0]==null)throw new NoSuchElementException();
			if(volume.length==1)return false;
			if(volume[current]==null) return false;
			if(volume[current+1]==null) return false;
			return true;
		}

		@Override
		public T next() {
			if(hasNext()) current++;
			return volume[current-1];
		}
		
	}
}