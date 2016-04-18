import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Tester{
	static Student[] students;
	static int N;
	public static void main(String args[]){
		Student sd1=new Student("Vasiliy","Ivanov",9.8);
		Student sd2=new Student("Taras","Vorotnyak",6.4);
		Student sd3=new Student("Olena","Kucherenko",5.9);
		Student sd4=new Student("Oleksandr","Pecheniy",8.2);
		Student sd5=new Student("Andriy","Dlugach",10.0);
		Student sd6=new Student("Mariya","Netreba",7.6);
		
		students=new Student[6];
		students[0]=sd1;
		students[1]=sd2;
		students[2]=sd3;
		students[3]=sd4;
		students[4]=sd5;
		students[5]=sd6;
		
		writeOut(students);
		
		sd1.sort(students,"firstName");
		writeOut(students);
		
		sd1.sort(students,"secondName");
		writeOut(students);
		
		sd1.sort(students,"midMark");
		writeOut(students);
		
	}
	public static void writeOut(Student[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i].firstName+" "+arr[i].secondName+" "+arr[i].midMark);
		}
		System.out.println("\n\n");
	}
}
