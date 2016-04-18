import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayStack<T> implements Iterable<T>{
	T[] volume;
	int last=0;
	public ArrayStack() {
		volume=(T[])new Object[8];
	}
	public void push(T i){
		if(last==volume.length-1){
			enlarge();
		}
		volume[last++]=i;
	}
	public T pop(){
		if(last==0) throw new NoSuchElementException();
		if(last<=volume.length/4&&(volume.length>8)){
			reduce();
		}
		T result=volume[last];
		volume[last-1]=null;
		last--;
		return result;
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
	private void reduce(){
		T[] temp=(T[])new Object[volume.length/2];
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
		return new IteratorAS();
	}
	class IteratorAS implements Iterator<T>{
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
