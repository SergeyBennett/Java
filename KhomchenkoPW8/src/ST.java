import java.util.Arrays;

public class ST<Key extends Comparable<Key>, Value>{
	private static Comparable[] keys;
	private static Comparable[] values;
	private int last;
	
	public <Key extends Comparable<Key>, Value>ST(){
		keys=(Key[])new Comparable[8];
		values=(Comparable[]) new Comparable[8];
		last=-1;
	}
	
	void put(Key key, Value val){
		for(int i=0;i<keys.length;i++){
			if(keys[i]==key){
				values[i]=(Comparable) val;
				return;
			}
		}
		if(last==keys.length-1){
			keys=Arrays.copyOf(keys, keys.length*2);
			values=Arrays.copyOf(values, values.length*2);
		}
		last++;
		keys[last]=key;
		values[last]=(Comparable) val;
	}
	
	
	Value get(Key key){
		
		for(int i=0;i<keys.length;i++){
			if(keys[i].equals(key)){
				return (Value) values[i];
			}
		}
		
		return null;
	}
	
	void delete(Key key){
		for(int i=0;i<keys.length;i++){
			System.out.println(i);
			if(keys[i].equals(key)){

				Comparable[] a1= Arrays.copyOfRange(keys, 0, i);
				Comparable[] a2= Arrays.copyOfRange(keys, i+1, keys.length);
				Comparable[] b1=Arrays.copyOfRange(values, 0, i);
				Comparable[] b2=Arrays.copyOfRange(values, i+1, keys.length);
				
				
		        int length = a1.length + a2.length;
		        Comparable[] result =new Comparable[length+1];
		        System.arraycopy(a1, 0, result, 0, a1.length);
		        System.arraycopy(a2, 0, result, a1.length, a2.length);
		        keys=result;
		        
		        length = b1.length + b2.length;
		        result =new Comparable[length+1];
		        System.arraycopy(b1, 0, result, 0, b1.length);
		        System.arraycopy(b2, 0, result, b1.length, b2.length);
		        values=result;
				last--;
				return;
			}
		}
	}
	
	boolean contains(Key key){
		for(int i=0;i<keys.length;i++){
			if(keys[i].equals(key)){
				return true;
			}
		}
		return false;

	}
	
	boolean isEmpty(){
		return last<0;
	}
	
	int size(){
		return last+1;
	}
	
	Key select(int k){
		return null;
		
	}
	
	void deleteMin(){
		int ind=0;
		for (int i=0;i<keys.length;i++){
			Comparable val1=values[i];
			Comparable val2=values[ind];
			if(val1.compareTo(val2)>0){
				ind=i;
			}
		}
		delete((Key)keys[ind]);
	}
	
	void deleteMax(){
		int ind=0;
		for (int i=0;i<keys.length;i++){
			Comparable val1=values[i];
			Comparable val2=values[ind];
			if(val1.compareTo(val2)<0){
				ind=i;
			}
		}
		delete((Key)keys[ind]);
	}
	
	int size(Key lo, Key hi){
		int size=0;
		for(int i=0;i<keys.length;i++){
			if(keys[i].compareTo(lo)>=0&&keys[i].compareTo(lo)<0){
				size++;
			}
		}
		
		return 0;

	}
	
	public String toString(){
		String res="Number {Key->Value}\n";
		for(int i=0;i<keys.length;i++){
			res+=i+" {"+keys[i]+"->"+values[i]+"}\n";
		}
		return res;
	}

	Iterable<Key> keys(){
		return null;
		
	}
	
	Iterable<Key> keys(Key lo,Key hi){
		return null;
		
	}
	
}