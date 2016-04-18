import java.util.Arrays;

public class Tester {

	public static void main(String[] args) {
		String str = null;
		ST st=new ST();
		System.out.println(st);
		st.put(22, "a");
		st.put(34, "b");
		st.put(11, "b");
		st.put(23, "c");
		st.put(22,"d");
		st.delete(22);
		System.out.println(st);
		System.out.println(st.size());
		System.out.println(st.isEmpty());
		
		
	}
	
}
