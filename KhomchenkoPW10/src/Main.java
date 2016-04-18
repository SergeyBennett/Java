import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static Scanner sc;
	static SearchDictionary sDict;
	static String query;
	static Iterable<String> result;
	public static void main(String args[]){
		sDict=new SearchDictionary();
		try {
			sc=new Scanner(new File("Text.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(sc.hasNext()){
			sDict.addWord(sc.next());
		}
		System.out.println(sDict);
		while(true){
			sc=new Scanner(System.in);
			System.out.println("Enter query:");
			query=sc.next();
			if(query.contains("*"))
				query=query.replace(query.substring(query.length()-1), "");
			result=sDict.query(query);
			System.out.println("Result:");
			for(String a:result){
				System.out.println(a);
			}
		}
	}
}
