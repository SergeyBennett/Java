import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T>  implements Iterable<T>{
	int last=0, first=0;
	private T[] volume;
	
	public ArrayQueue() {
		this.volume=(T[])new Object[8];
	}
	
	public void enqueue(T i){
		if((last+1)==volume.length) this.enlarge();
		volume[last++]=i;
	}
	public T dequeue(){
		if(first==last+1) throw new NoSuchElementException();
		if(last-first<volume.length/2&&volume.length>8) this.reduce();
		return volume[++first];
	}
	private void enlarge(){
		T[] newVolume=(T[])new Object[this.volume.length*2];
		for(int i=first;i<last;i++){
			newVolume[i]=volume[i];
		}
		last-=first;
		first=0;
		this.volume=newVolume;
	}
	public void reduce(){
		T[] newVolume=(T[])new Object[this.volume.length/2];
		for(int i=first;i<last;i++){
			newVolume[i]=volume[i];
		}
		last-=first;
		first=0;
		this.volume=newVolume;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new IteratorAQ();
	}
	public int size(){
		return this.volume.length;
	}
	public boolean isEmpty(){
		return last==first;
	}

	public void writeAll(){
		String result="["+volume[0];
		for(int i=1;i<volume.length;i++){
			result+=", "+volume[i];
		}
		System.out.println( result+="]");
	}
	
	class IteratorAQ implements Iterator<T>{
		int current = first;
		@Override
		public boolean hasNext() {
			if(volume[0]==null)throw new NoSuchElementException();
			if(current>=last) return false;
			return true;
		}

		@Override
		public T next() {
			if(hasNext()) current++;
			return volume[current-1];
		}
		
	}
	
}
