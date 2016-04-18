public class Student implements Comparable<Student>{
	
	String firstName;
	String secondName;
	double midMark;
	
	public Student(String firstName,String secondName,double midMark){
		this.firstName=firstName;
		this.secondName=secondName;
		this.midMark=midMark;
	}
	
	public int compareToBy(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Student that) {
		return this.secondName.compareTo(that.secondName);
	}
	public int compareToByFirstName(Student that) {
		return this.firstName.compareTo(that.firstName);
	}
	public int compareToByMark(Student that) {
		if(this.midMark<that.midMark)return -1;
		if(this.midMark>that.midMark)return 1;
		return 0;
	}
	
	public static boolean less(String comp,Student first,Student second){
		switch(comp){
		case "secondName":
			return first.compareTo(second)<0;
		case "firstName":
			return first.compareToByFirstName(second)<0;
		case "midMark":
			return first.compareToByMark(second)<0;
		default:
			return false;
		}
	}
	
	private static void exch(Comparable[] a, int i, int j){
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static Student[] sort(Student[] a,String comp){
		int n=a.length;
		for (int i=0;i<n;i++){
			for (int j = i;j>0;j--)
				if (less(comp,a[j],a[j-1]))
					exch(a,j,j-1);
				else break;
		}
		return a;
	}
	
}
