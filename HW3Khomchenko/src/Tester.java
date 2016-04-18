import java.util.Iterator;

public class Tester {
	
	static ArrayQueue aqtest;
	static ArrayStack astest;
	static Bag btest;
	static LinkedQueue lqtest;
	static LinkedStack lstest;
	
	static Iterator aqIterator;
	static Iterator asIterator;
	static Iterator bIterator;
	static Iterator lqIterator;
	static Iterator lsIterator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aqtest=new ArrayQueue();
		aqIterator=aqtest.iterator();
		System.out.println(aqtest.size());
		aqtest.enqueue("a");
		aqtest.enqueue("b");
		System.out.println(aqIterator.hasNext());
		aqtest.enqueue("c");
		aqtest.writeAll();
		aqtest.dequeue();
		aqtest.writeAll();
		
		
		System.out.println("");
		astest=new ArrayStack();
		asIterator=astest.iterator();
		System.out.println(astest.size());
		astest.push("a");
		astest.push("b");
		System.out.println(asIterator.hasNext());
		astest.push("c");
		astest.writeAll();
		astest.pop();
		astest.writeAll();
		astest.push("d");
		astest.writeAll();
		
		System.out.println("");
		btest=new Bag();
		bIterator=btest.iterator();
		System.out.println(btest.size());
		btest.add("a");
		btest.add("b");
		System.out.println(bIterator.hasNext());
		btest.add("c");
		btest.writeAll();
		
		System.out.println("");
		lstest=new LinkedStack();
		lsIterator=lstest.iterator();
		lstest.push("a");
		lstest.push("b");
		lstest.push("c");
		lstest.pop();
		lstest.push("d");
		
		System.out.println("");
		lqtest=new LinkedQueue();
		lqIterator=astest.iterator();
		lqtest.push("a");
		lqtest.push("b");
		lqtest.push("c");
		lqtest.pop();
		lqtest.push("d");
		
	}

}
